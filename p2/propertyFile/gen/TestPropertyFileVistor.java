import org.antlr.v4.misc.OrderedHashMap;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.tree.*;

import java.io.*;
import java.io.FileInputStream;
import java.util.Map;

public class TestPropertyFileVistor {
    public static class PropertyFileVisitor extends PropertyFileBaseVisitor<Void> {
        Map<String, String> props = new OrderedHashMap<>();

        public Void visitProp(PropertyFileParser.PropContext ctx) {
            String id = ctx.ID().getText();
            String value = ctx.STRING().getText();
            props.put(id, value);
            return null;
        }
    }
    public static void main(String[] args) throws Exception {
        ANTLRInputStream input = new ANTLRInputStream(
            new FileInputStream(
                args.length > 0 ? args[0] : "../t.properties"
            )
        );
        PropertyFileLexer lexer = new PropertyFileLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PropertyFileParser parser = new PropertyFileParser(tokens);

        ParseTree tree = parser.file();

        PropertyFileVisitor loader = new PropertyFileVisitor();
        loader.visit(tree);
        System.out.println(loader.props);
    }

}