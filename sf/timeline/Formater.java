/* **********************************************

  File Name: Formater.java

  Author: zhengdongjian@tju.edu.cn

  Created Time: Tue 19 Apr 2016 09:35:47 PM CST

*********************************************** */
import java.io.*;
import java.util.*;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

/**
 * format json to more readable
 *
 * 1 '{}'(object) cause indent
 * 2 ':'(pair) follows a space(' ')
 * 3 each pair follows a new-line symbol
 * :)
 */
public class Formater extends JSONBaseListener {
	String indent = "";
	public void enterObject(JSONParser.ObjectContext ctx) {
		//System.out.println(ctx.getChild(0));
		System.out.print("{\n");
		indent += "  ";
	}
	public void exitObject(JSONParser.ObjectContext ctx) {
		indent = indent.substring(0, indent.length() - 2);
		System.out.print("\n" + indent + "}");
	}
	public void enterPair(JSONParser.PairContext ctx) {
		System.out.print(indent + ctx.key().getText() + ": ");
	}
	public void exitPair(JSONParser.PairContext ctx) {
		System.out.print(",");
	}
	public static void main(String[] args) throws Exception {
		ANTLRInputStream is = new ANTLRInputStream(new BufferedInputStream(
					new FileInputStream(args.length > 0 ? args[0] : "./timeline.json")));

		JSONLexer lexer = new JSONLexer(is);

		CommonTokenStream tokens = new CommonTokenStream(lexer);

		JSONParser parser = new JSONParser(tokens);
		parser.setBuildParseTree(true);

		ParseTree tree = parser.json();

		ParseTreeWalker walker = new ParseTreeWalker();
		Formater formater = new Formater();

		walker.walk(formater, tree);

		//System.out.println("hello!");
	}
}
