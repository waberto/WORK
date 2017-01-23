import org.antlr.runtime.*;
 
public class Test {
    public static void main(String[] args) throws Exception {
        ANTLRFileStream input = new ANTLRFileStream(args[0]);
        GrammaireLexer lexer = new GrammaireLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GrammaireParser parser = new GrammaireParser(tokens);
        parser.doc();
    }
}
