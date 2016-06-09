// Generated from C:/Users/Administrator/git/compile2016/vars\Vars.g4 by ANTLR 4.5.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link VarsParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface VarsVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link VarsParser#file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile(VarsParser.FileContext ctx);
	/**
	 * Visit a parse tree produced by {@link VarsParser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(VarsParser.VarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link VarsParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(VarsParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link VarsParser#functionDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDecl(VarsParser.FunctionDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link VarsParser#formalParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameters(VarsParser.FormalParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link VarsParser#formalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameter(VarsParser.FormalParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link VarsParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(VarsParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link VarsParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(VarsParser.StatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Call}
	 * labeled alternative in {@link VarsParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall(VarsParser.CallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Not}
	 * labeled alternative in {@link VarsParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot(VarsParser.NotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Mult}
	 * labeled alternative in {@link VarsParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMult(VarsParser.MultContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link VarsParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSub(VarsParser.AddSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Equal}
	 * labeled alternative in {@link VarsParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqual(VarsParser.EqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Var}
	 * labeled alternative in {@link VarsParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(VarsParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link VarsParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParens(VarsParser.ParensContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Index}
	 * labeled alternative in {@link VarsParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndex(VarsParser.IndexContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Negate}
	 * labeled alternative in {@link VarsParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegate(VarsParser.NegateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Int}
	 * labeled alternative in {@link VarsParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt(VarsParser.IntContext ctx);
	/**
	 * Visit a parse tree produced by {@link VarsParser#exprList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprList(VarsParser.ExprListContext ctx);
}