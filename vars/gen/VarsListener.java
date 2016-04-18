// Generated from C:/Users/Administrator/git/compile2016/vars\Vars.g4 by ANTLR 4.5.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link VarsParser}.
 */
public interface VarsListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link VarsParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(VarsParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link VarsParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(VarsParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link VarsParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(VarsParser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link VarsParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(VarsParser.VarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link VarsParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(VarsParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link VarsParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(VarsParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link VarsParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDecl(VarsParser.FunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link VarsParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDecl(VarsParser.FunctionDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link VarsParser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameters(VarsParser.FormalParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link VarsParser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameters(VarsParser.FormalParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link VarsParser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameter(VarsParser.FormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link VarsParser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameter(VarsParser.FormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link VarsParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(VarsParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link VarsParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(VarsParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link VarsParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(VarsParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link VarsParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(VarsParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Call}
	 * labeled alternative in {@link VarsParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCall(VarsParser.CallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Call}
	 * labeled alternative in {@link VarsParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCall(VarsParser.CallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Not}
	 * labeled alternative in {@link VarsParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNot(VarsParser.NotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Not}
	 * labeled alternative in {@link VarsParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNot(VarsParser.NotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Mult}
	 * labeled alternative in {@link VarsParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMult(VarsParser.MultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Mult}
	 * labeled alternative in {@link VarsParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMult(VarsParser.MultContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link VarsParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddSub(VarsParser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link VarsParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddSub(VarsParser.AddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Equal}
	 * labeled alternative in {@link VarsParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEqual(VarsParser.EqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Equal}
	 * labeled alternative in {@link VarsParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEqual(VarsParser.EqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Var}
	 * labeled alternative in {@link VarsParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVar(VarsParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Var}
	 * labeled alternative in {@link VarsParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVar(VarsParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link VarsParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParens(VarsParser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link VarsParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParens(VarsParser.ParensContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Index}
	 * labeled alternative in {@link VarsParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIndex(VarsParser.IndexContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Index}
	 * labeled alternative in {@link VarsParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIndex(VarsParser.IndexContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Negate}
	 * labeled alternative in {@link VarsParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNegate(VarsParser.NegateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Negate}
	 * labeled alternative in {@link VarsParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNegate(VarsParser.NegateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Int}
	 * labeled alternative in {@link VarsParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInt(VarsParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Int}
	 * labeled alternative in {@link VarsParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInt(VarsParser.IntContext ctx);
	/**
	 * Enter a parse tree produced by {@link VarsParser#exprList}.
	 * @param ctx the parse tree
	 */
	void enterExprList(VarsParser.ExprListContext ctx);
	/**
	 * Exit a parse tree produced by {@link VarsParser#exprList}.
	 * @param ctx the parse tree
	 */
	void exitExprList(VarsParser.ExprListContext ctx);
}