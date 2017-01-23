import org.antlr.runtime.*;
 
public class Test {
    public static void main(String[] args) throws Exception {
        ANTLRFileStream input = new ANTLRFileStream(args[0]);
        EssaieLexer lexer = new EssaieLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        EssaieParser parser = new EssaieParser(tokens);
        parser.objet();
    }
}
