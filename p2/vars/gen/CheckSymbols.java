import java.util.*;
import java.io.*;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.misc.*;

public class CheckSymbols {
    public static Symbol.Type getType(int tokenType) {
        switch (tokenType) {
            case VarsParser.K_VOID:
                return Symbol.Type.tVOID;
            case VarsParser.K_INT:
                return Symbol.Type.tINT;
            case VarsParser.K_FLOAT:
                return Symbol.Type.tFLOAT;
        }
        return Symbol.Type.tINVALID;
    }

    public static void error(Token t, String msg) {
        System.err.printf("line %d:%d: error: %s\n", t.getLine(), t.getCharPositionInLine(), msg);
    }

    static class DefPhase extends VarsBaseListener {
        ParseTreeProperty<Scope> scopes = new ParseTreeProperty<Scope>();
        GlobalScope globals;
        Scope currentScope;

        /**
         * rule that influence scopes or symbols:
         * file
         * functionDecl
         * formalParameter
         * varDecl
         * varDecl
         * block
         * formalParameter
         */

        void saveScope(ParserRuleContext ctx, Scope s) {
            scopes.put(ctx, s);
        }

        void defineVar(VarsParser.TypeContext typeCtx, Token token) {
            int typeTokenType = typeCtx.start.getType();
            Symbol.Type type = CheckSymbols.getType(typeTokenType);
            VariableSymbol var = new VariableSymbol(token.getText(), type);
            currentScope.define(var);
        }

        public void enterFile(VarsParser.FileContext ctx) {
            globals = new GlobalScope(null);
            currentScope = globals;
        }

        public void exitFile(VarsParser.FileContext ctx) {
            System.out.println(globals);
        }

        public void enterFunctionDecl(VarsParser.FunctionDeclContext ctx) {
            String name = ctx.ID().getText();
            int typeTokenType = ctx.type().start.getType();
            Symbol.Type type = CheckSymbols.getType(typeTokenType);

            //make new scope
            FunctionSymbol function = new FunctionSymbol(name, type, currentScope);
            currentScope.define(function);
            saveScope(ctx, function);
            currentScope = function;
        }

        public void exitFunctionDecl(VarsParser.FunctionDeclContext ctx) {
            System.out.println(currentScope);
            currentScope = currentScope.getEnclosingScope();
        }

        public void enterBlock(VarsParser.BlockContext ctx) {
            currentScope = new LocalScope(currentScope);
            saveScope(ctx, currentScope);
        }

        public void exitBlock(VarsParser.BlockContext ctx) {
            System.out.println(currentScope);
            currentScope = currentScope.getEnclosingScope();
        }

        public void exitFormalParameter(VarsParser.FormalParameterContext ctx) {
            defineVar(ctx.type(), ctx.ID().getSymbol());
        }

        public void exitVarDecl(VarsParser.VarDeclContext ctx) {
            defineVar(ctx.type(), ctx.ID().getSymbol());
        }
    }

    static class RefPhase extends VarsBaseListener {
        ParseTreeProperty<Scope> scopes;
        GlobalScope globals;
        Scope currentScope; // resolve symbols starting in this scope

        public RefPhase(GlobalScope globals, ParseTreeProperty<Scope> scopes) {
            this.scopes = scopes;
            this.globals = globals;
        }
        public void enterFile(VarsParser.FileContext ctx) {
            currentScope = globals;
        }

        public void enterFunctionDecl(VarsParser.FunctionDeclContext ctx) {
            currentScope = scopes.get(ctx);
        }
        public void exitFunctionDecl(VarsParser.FunctionDeclContext ctx) {
            currentScope = currentScope.getEnclosingScope();
        }

        public void enterBlock(VarsParser.BlockContext ctx) {
            currentScope = scopes.get(ctx);
        }
        public void exitBlock(VarsParser.BlockContext ctx) {
            currentScope = currentScope.getEnclosingScope();
        }

        public void exitVar(VarsParser.VarContext ctx) {
            String name = ctx.ID().getSymbol().getText();
            Symbol var = currentScope.resolve(name);
            if ( var==null ) {
                CheckSymbols.error(ctx.ID().getSymbol(), "no such variable: "+name);
            }
            if ( var instanceof FunctionSymbol ) {
                CheckSymbols.error(ctx.ID().getSymbol(), name+" is not a variable");
            }
        }

        public void exitCall(VarsParser.CallContext ctx) {
            // can only handle f(...) not expr(...)
            String funcName = ctx.ID().getText();
            Symbol meth = currentScope.resolve(funcName);
            if ( meth==null ) {
                CheckSymbols.error(ctx.ID().getSymbol(), "no such function: "+funcName);
            }
            if ( meth instanceof VariableSymbol ) {
                CheckSymbols.error(ctx.ID().getSymbol(), funcName+" is not a function");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        ANTLRInputStream cin = new ANTLRInputStream(
            new BufferedInputStream(
                new FileInputStream(
                    args.length > 0 ? args[0] : "../data.vars"
                )
            )
        );

        VarsLexer lexer = new VarsLexer(cin);

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        VarsParser parser = new VarsParser(tokens);

        ParseTree tree = parser.file();

        ParseTreeWalker walker = new ParseTreeWalker();

        DefPhase def = new DefPhase();
        walker.walk(def, tree);

        RefPhase ref = new RefPhase(def.globals, def.scopes);
        walker.walk(ref, tree);
    }
}