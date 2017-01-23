import java.io.*;
import org.antlr.runtime.*;
import org.antlr.runtime.debug.DebugEventSocketProxy;


public class __Test__ {

    public static void main(String args[]) throws Exception {
        astLexer lex = new astLexer(new ANTLRFileStream("/home/waberto/Documents/COMP/TP1_AST/output/__Test___input.txt", "UTF8"));
        CommonTokenStream tokens = new CommonTokenStream(lex);

        astParser g = new astParser(tokens, 49100, null);
        try {
            g.objet();
        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }
}