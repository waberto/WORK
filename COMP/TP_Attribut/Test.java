import org.antlr.runtime.*;
 
public class Test {
    public static void main(String[] args) throws Exception {
        ANTLRFileStream input = new ANTLRFileStream(args[0]);
        Grammaire_NtripleLexer lexer = new Grammaire_NtripleLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        Grammaire_NtripleParser parser = new Grammaire_NtripleParser(tokens);
        parser.doc();
    }
}
