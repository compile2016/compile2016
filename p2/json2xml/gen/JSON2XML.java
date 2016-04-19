import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.FileInputStream;
import java.lang.StringBuilder;

public class JSON2XML {
    public static class XMLEmitter extends JSONBaseListener {
        private static boolean DEBUG = false;

        ParseTreeProperty<String> xml = new ParseTreeProperty<String>();

        String getXML(ParseTree ctx) {
            return xml.get(ctx);
        }

        void setXML(ParseTree ctx, String s) {
            xml.put(ctx, s);
        }

        public void exitJson(JSONParser.JsonContext ctx) {
            setXML(ctx, getXML(ctx.getChild(0)));
        }

        public void exitAnObject(JSONParser.AnObjectContext ctx) {
            StringBuilder buf = new StringBuilder();
            buf.append("\n");
            for (JSONParser.PairContext pctx: ctx.pair()) {
                buf.append(getXML(pctx));
            }
            setXML(ctx, buf.toString());
        }

        public void exitEmptyObject(JSONParser.EmptyObjectContext ctx) {
            setXML(ctx, "");
        }

        public void exitAtom(JSONParser.AtomContext ctx) {
            setXML(ctx, ctx.getText());
        }

        public void exitString(JSONParser.StringContext ctx) {
            setXML(ctx, removeQuotes(ctx.getText()));
        }

        public void exitObjectValue(JSONParser.ObjectValueContext ctx) {
            setXML(ctx, getXML(ctx.object()));
        }

        public void exitArrayValue(JSONParser.ArrayValueContext ctx) {
            setXML(ctx, getXML(ctx.array()));
        }

        public void exitPair(JSONParser.PairContext ctx) {
            String tag = removeQuotes(ctx.STRING().getText());
            JSONParser.ValueContext vctx = ctx.value();
            String x = String.format("<%s>%s</%s>\n", tag, getXML(vctx), tag);
            setXML(ctx, x);
        }

        public void exitArrayOfValues(JSONParser.ArrayOfValuesContext ctx) {
            StringBuilder buf = new StringBuilder();
            buf.append("\n");
            for (JSONParser.ValueContext vctx: ctx.value()) {
                buf.append("<element>");
                buf.append(getXML(vctx));
                buf.append("</element>");
                buf.append("\n");
            }
            setXML(ctx, buf.toString());
        }

        public void exitEmptyArray(JSONParser.EmptyArrayContext ctx) {
            setXML(ctx, "");
        }

        public final String removeQuotes(String s) {
            if (s == null || s.charAt(0) != '"') {
                return s;
            } else {
                if (XMLEmitter.DEBUG) {
                    System.out.println("removeQuotes: " + s + " -> " + s.substring(1, s.length() - 1));
                }
                return s.substring(1, s.length() - 1);
            }
        }
    }

    public static void main(String args[]) throws Exception {
        ANTLRInputStream cin = new ANTLRInputStream(
            new FileInputStream(
                args.length > 0 ? args[0] : "../data.json"
            )
        );
        JSONLexer lexer = new JSONLexer(cin);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        JSONParser parser = new JSONParser(tokens);
        parser.setBuildParseTree(true);
        ParseTree tree = parser.json();

        ParseTreeWalker walker = new ParseTreeWalker();
        XMLEmitter converter = new XMLEmitter();
        walker.walk(converter, tree);
        System.out.println(converter.getXML(tree));
    }
}