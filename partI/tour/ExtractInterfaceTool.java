import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.*;
import java.io.*;

public class ExtractInterfaceTool {
	public static void main(String args[]) throws Exception {
		String file = args.length > 0 ? args[0] : "Demo.java";
		JavaLexer lexer = new JavaLexer(new ANTLRInputStream(new FileInputStream(file)));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		JavaParser parser = new JavaParser(tokens);
		ParseTree tree = parser.compilationUnit();

		ParseTreeWalker walker = new ParseTreeWalker();
		ExtractInterfaceListener extractor = new ExtractInterfaceListener(parser);
		walker.walk(extractor, tree);
	}
}
