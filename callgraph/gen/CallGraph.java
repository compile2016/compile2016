import java.io.*;
import java.util.*;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.misc.*;

public class CallGraph {
    static class Graph {
        Set<String> nodes = new OrderedHashSet<String>();
        MultiMap<String, String> edges = new MultiMap<String, String>();

        public void addEdge(String source, String target) {
            edges.map(source, target);
        }

        public String toDot() {
            StringBuilder buf = new StringBuilder();
            buf.append("digraph G {\n");
            buf.append("  ranksep=.25;\n");
            buf.append("  edge [arrowsize=.5]\n");
            buf.append("  node [shape=circle, fontname=\"ArialNarrow\",\n");
            buf.append("        fontsize=12, fixedsize=true, height=.45];\n");
            buf.append("  ");
            for (String node : nodes) {
                buf.append(node);
                buf.append("; ");
            }
            buf.append("\n");
            for (String src: edges.keySet()) {
                for (String trg: edges.get(src)) {
                    buf.append("  ");
                    buf.append(src);
                    buf.append(" -> ");
                    buf.append(trg);
                    buf.append(";\n");
                }
            }
            buf.append("}\n");
            return buf.toString();
        }

//        public String toString() {
//            return toDot();
//        }
    }

    static class FunctionListener extends CymbolBaseListener {
        Graph graph = new Graph();
        String currentFunctionName = null;

        public void enterFunctionDecl(CymbolParser.FunctionDeclContext ctx) {
            currentFunctionName = ctx.ID().getText();

            graph.nodes.add(currentFunctionName);
        }

        public void exitCall(CymbolParser.CallContext ctx) {
            String funcName = ctx.ID().getText();
            graph.addEdge(currentFunctionName, funcName);
        }
    }

    public static void main(String[] args) throws Exception {
        ANTLRInputStream cin = new ANTLRInputStream(
            new BufferedInputStream(
                new FileInputStream(
                    args.length > 0 ? args[0] : "../data.cymbol"
                )
            )
        );

        CymbolLexer lexer = new CymbolLexer(cin);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CymbolParser parser = new CymbolParser(tokens);
        parser.setBuildParseTree(true);

        ParseTree tree = parser.file();

        ParseTreeWalker walker = new ParseTreeWalker();
        FunctionListener collector = new FunctionListener();
        walker.walk(collector, tree);
        System.out.println(collector.graph.toString());
        System.out.println(collector.graph.toDot());
    }
}