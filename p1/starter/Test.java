import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.*;

public class Test {
	public static void main(String args[]) throws Exception {

		FileInputStream fis = new FileInputStream("Expression.txt");

		ANTLRInputStream input = new ANTLRInputStream(fis);
		
		//lexer
		ArrayInitLexer lexer = new ArrayInitLexer(input);

		//buffer
		CommonTokenStream tokens = new CommonTokenStream(lexer);

		//parser
		ArrayInitParser parser = new ArrayInitParser(tokens);
		ParseTree tree = parser.init();

		System.out.println(tree.toStringTree(parser));
	}
}
