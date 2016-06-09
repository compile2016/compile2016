// Generated from cymbol.g4 by ANTLR 4.5.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link cymbolParser}.
 */
public interface cymbolListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link cymbolParser#cymbol}.
	 * @param ctx the parse tree
	 */
	void enterCymbol(cymbolParser.CymbolContext ctx);
	/**
	 * Exit a parse tree produced by {@link cymbolParser#cymbol}.
	 * @param ctx the parse tree
	 */
	void exitCymbol(cymbolParser.CymbolContext ctx);
	/**
	 * Enter a parse tree produced by {@link cymbolParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(cymbolParser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link cymbolParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(cymbolParser.VarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link cymbolParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(cymbolParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link cymbolParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(cymbolParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link cymbolParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDecl(cymbolParser.FunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link cymbolParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDecl(cymbolParser.FunctionDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link cymbolParser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameters(cymbolParser.FormalParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link cymbolParser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameters(cymbolParser.FormalParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link cymbolParser#formalParamenter}.
	 * @param ctx the parse tree
	 */
	void enterFormalParamenter(cymbolParser.FormalParamenterContext ctx);
	/**
	 * Exit a parse tree produced by {@link cymbolParser#formalParamenter}.
	 * @param ctx the parse tree
	 */
	void exitFormalParamenter(cymbolParser.FormalParamenterContext ctx);
	/**
	 * Enter a parse tree produced by {@link cymbolParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(cymbolParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link cymbolParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(cymbolParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link cymbolParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(cymbolParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link cymbolParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(cymbolParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link cymbolParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(cymbolParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link cymbolParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(cymbolParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link cymbolParser#exprList}.
	 * @param ctx the parse tree
	 */
	void enterExprList(cymbolParser.ExprListContext ctx);
	/**
	 * Exit a parse tree produced by {@link cymbolParser#exprList}.
	 * @param ctx the parse tree
	 */
	void exitExprList(cymbolParser.ExprListContext ctx);
}