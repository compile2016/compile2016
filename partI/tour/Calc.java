import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.*;

public class Calc {
	public static void main(String args[]) throws Exception {
		String inputFile = args.length > 0 ? args[0] : "t.expr";
		FileInputStream fis = new FileInputStream(inputFile);
		ANTLRInputStream input = new ANTLRInputStream(fis);
		
		//ExprLexer lexer = new ExprLexer(input);
		LabeledExprLexer lexer = new LabeledExprLexer(input);
		
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		
		//ExprParser parser = new ExprParser(tokens);
		LabeledExprParser parser = new LabeledExprParser(tokens);

		ParseTree tree = parser.prog();
		//System.out.println(tree.toStringTree(parser));
		EvalVisitor eval = new EvalVisitor();
		eval.visit(tree);
	}
}
