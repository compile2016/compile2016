import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;

public class ExtractInterfaceListener extends JavaBaseListener {
	JavaParser parser;
	public ExtractInterfaceListener(JavaParser parser) {
		this.parser = parser;
	}

	@Override
	public void enterImportDeclaration(JavaParser.ImportDeclarationContext ctx) {
		System.out.println(parser.getTokenStream().getText(ctx));
	}

	@Override
	public void enterClassDeclaration(JavaParser.ClassDeclarationContext ctx) {
		System.out.println("interface I" + ctx.Identifier() + " {");
	}

	@Override
	public void exitClassDeclaration(JavaParser.ClassDeclarationContext ctx) {
		System.out.println("}");
	}

	@Override
	public void enterMethodDeclaration(JavaParser.MethodDeclarationContext ctx) {
		TokenStream tokens = parser.getTokenStream();
		String type = ctx.type() != null ? tokens.getText(ctx.type()) : "void";
		String args = tokens.getText(ctx.formalParameters());

		//String toString(int id);
		System.out.println("\t" + type + " " + ctx.Identifier() + args + ";");
	}
}
