// $ANTLR 3.4 /home/waberto/Documents/COMP/TP1_AST/grammaire_AST.g 2016-10-13 18:53:11

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.debug.*;
import java.io.IOException;
import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class grammaire_ASTParser extends DebugParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ID"
    };

    public static final int EOF=-1;
    public static final int ID=4;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


public static final String[] ruleNames = new String[] {
    "invalidRule", "rul", "rule"
};

public static final boolean[] decisionCanBacktrack = new boolean[] {
    false, // invalid decision
};

 
    public int ruleLevel = 0;
    public int getRuleLevel() { return ruleLevel; }
    public void incRuleLevel() { ruleLevel++; }
    public void decRuleLevel() { ruleLevel--; }
    public grammaire_ASTParser(TokenStream input) {
        this(input, DebugEventSocketProxy.DEFAULT_DEBUGGER_PORT, new RecognizerSharedState());
    }
    public grammaire_ASTParser(TokenStream input, int port, RecognizerSharedState state) {
        super(input, state);
        DebugEventSocketProxy proxy =
            new DebugEventSocketProxy(this,port,adaptor);
        setDebugListener(proxy);
        setTokenStream(new DebugTokenStream(input,proxy));
        try {
            proxy.handshake();
        }
        catch (IOException ioe) {
            reportError(ioe);
        }
        TreeAdaptor adap = new CommonTreeAdaptor();
        setTreeAdaptor(adap);
        proxy.setTreeAdaptor(adap);
    }

public grammaire_ASTParser(TokenStream input, DebugEventListener dbg) {
    super(input, dbg);
     
    TreeAdaptor adap = new CommonTreeAdaptor();
    setTreeAdaptor(adap);


}

protected boolean evalPredicate(boolean result, String predicate) {
    dbg.semanticPredicate(result, predicate);
    return result;
}

protected DebugTreeAdaptor adaptor;
public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = new DebugTreeAdaptor(dbg,adaptor);


}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}

    public String[] getTokenNames() { return grammaire_ASTParser.tokenNames; }
    public String getGrammarFileName() { return "/home/waberto/Documents/COMP/TP1_AST/grammaire_AST.g"; }


    public static class rule_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rule"
    // /home/waberto/Documents/COMP/TP1_AST/grammaire_AST.g:7:1: rule : ID rul -> ^( ID rul ) ;
    public final grammaire_ASTParser.rule_return rule() throws RecognitionException {
        grammaire_ASTParser.rule_return retval = new grammaire_ASTParser.rule_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token ID1=null;
        grammaire_ASTParser.rul_return rul2 =null;


        CommonTree ID1_tree=null;
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleSubtreeStream stream_rul=new RewriteRuleSubtreeStream(adaptor,"rule rul");
        try { dbg.enterRule(getGrammarFileName(), "rule");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(7, 0);

        try {
            // /home/waberto/Documents/COMP/TP1_AST/grammaire_AST.g:7:7: ( ID rul -> ^( ID rul ) )
            dbg.enterAlt(1);

            // /home/waberto/Documents/COMP/TP1_AST/grammaire_AST.g:7:10: ID rul
            {
            dbg.location(7,10);
            ID1=(Token)match(input,ID,FOLLOW_ID_in_rule34);  
            stream_ID.add(ID1);

            dbg.location(7,13);
            pushFollow(FOLLOW_rul_in_rule36);
            rul2=rul();

            state._fsp--;

            stream_rul.add(rul2.getTree());

            // AST REWRITE
            // elements: rul, ID
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 7:17: -> ^( ID rul )
            {
                dbg.location(7,20);
                // /home/waberto/Documents/COMP/TP1_AST/grammaire_AST.g:7:20: ^( ID rul )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                dbg.location(7,22);
                root_1 = (CommonTree)adaptor.becomeRoot(
                stream_ID.nextNode()
                , root_1);

                dbg.location(7,25);
                adaptor.addChild(root_1, stream_rul.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(7, 28);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "rule");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "rule"


    public static class rul_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rul"
    // /home/waberto/Documents/COMP/TP1_AST/grammaire_AST.g:8:1: rul : ID ;
    public final grammaire_ASTParser.rul_return rul() throws RecognitionException {
        grammaire_ASTParser.rul_return retval = new grammaire_ASTParser.rul_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token ID3=null;

        CommonTree ID3_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "rul");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(8, 0);

        try {
            // /home/waberto/Documents/COMP/TP1_AST/grammaire_AST.g:8:5: ( ID )
            dbg.enterAlt(1);

            // /home/waberto/Documents/COMP/TP1_AST/grammaire_AST.g:8:7: ID
            {
            root_0 = (CommonTree)adaptor.nil();


            dbg.location(8,7);
            ID3=(Token)match(input,ID,FOLLOW_ID_in_rul53); 
            ID3_tree = 
            (CommonTree)adaptor.create(ID3)
            ;
            adaptor.addChild(root_0, ID3_tree);


            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(8, 8);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "rul");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "rul"

    // Delegated rules


 

    public static final BitSet FOLLOW_ID_in_rule34 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rul_in_rule36 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_rul53 = new BitSet(new long[]{0x0000000000000002L});

}