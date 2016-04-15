import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        ANTLRInputStream cin = new ANTLRInputStream(
            new BufferedInputStream(
                new FileInputStream("expression.txt")
            )
        );

        if (cin == null) {
            System.out.println("no!");
        }

        PropertyFileLexer lexer = new PropertyFileLexer(cin);

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        PropertyFilePrinter printer = new PropertyFilePrinter(tokens);

        printer.file();
    }
}
/*
69077002
假发
兄弟
*/