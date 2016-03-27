import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.*;

public class Translate {
	public static void main(String[] args) throws Exception {
		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream("Expression.txt"));
		ArrayInitLexer lexer = new ArrayInitLexer(input);

		CommonTokenStream tokens = new CommonTokenStream(lexer);

		ArrayInitParser parser = new ArrayInitParser(tokens);
		ParseTree tree = parser.init();

		//parse tree walker
		ParseTreeWalker walker = new ParseTreeWalker();

		walker.walk(new ShortToUnicodeString(), tree);
		System.out.println();
	}
}