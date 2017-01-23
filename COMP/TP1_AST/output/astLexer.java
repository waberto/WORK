// $ANTLR 3.4 /home/waberto/Documents/COMP/TP1_AST/ast.g 2016-10-13 19:13:22

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class astLexer extends Lexer {
    public static final int EOF=-1;
    public static final int ID=4;
    public static final int WS=5;

    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public astLexer() {} 
    public astLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public astLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "/home/waberto/Documents/COMP/TP1_AST/ast.g"; }

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/waberto/Documents/COMP/TP1_AST/ast.g:16:5: ( '<' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '-' | '&' )+ '>' | '\"' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '-' | '&' )+ '\"' )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='<') ) {
                alt3=1;
            }
            else if ( (LA3_0=='\"') ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }
            switch (alt3) {
                case 1 :
                    // /home/waberto/Documents/COMP/TP1_AST/ast.g:16:8: '<' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '-' | '&' )+ '>'
                    {
                    match('<'); 

                    // /home/waberto/Documents/COMP/TP1_AST/ast.g:16:12: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '-' | '&' )+
                    int cnt1=0;
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0=='&'||LA1_0=='-'||(LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // /home/waberto/Documents/COMP/TP1_AST/ast.g:
                    	    {
                    	    if ( input.LA(1)=='&'||input.LA(1)=='-'||(input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt1 >= 1 ) break loop1;
                                EarlyExitException eee =
                                    new EarlyExitException(1, input);
                                throw eee;
                        }
                        cnt1++;
                    } while (true);


                    match('>'); 

                    }
                    break;
                case 2 :
                    // /home/waberto/Documents/COMP/TP1_AST/ast.g:16:55: '\"' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '-' | '&' )+ '\"'
                    {
                    match('\"'); 

                    // /home/waberto/Documents/COMP/TP1_AST/ast.g:16:59: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '-' | '&' )+
                    int cnt2=0;
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0=='&'||LA2_0=='-'||(LA2_0 >= '0' && LA2_0 <= '9')||(LA2_0 >= 'A' && LA2_0 <= 'Z')||(LA2_0 >= 'a' && LA2_0 <= 'z')) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // /home/waberto/Documents/COMP/TP1_AST/ast.g:
                    	    {
                    	    if ( input.LA(1)=='&'||input.LA(1)=='-'||(input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt2 >= 1 ) break loop2;
                                EarlyExitException eee =
                                    new EarlyExitException(2, input);
                                throw eee;
                        }
                        cnt2++;
                    } while (true);


                    match('\"'); 

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/waberto/Documents/COMP/TP1_AST/ast.g:17:5: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // /home/waberto/Documents/COMP/TP1_AST/ast.g:17:9: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // /home/waberto/Documents/COMP/TP1_AST/ast.g:17:9: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0 >= '\t' && LA4_0 <= '\n')||LA4_0=='\r'||LA4_0==' ') ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /home/waberto/Documents/COMP/TP1_AST/ast.g:
            	    {
            	    if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            skip();

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WS"

    public void mTokens() throws RecognitionException {
        // /home/waberto/Documents/COMP/TP1_AST/ast.g:1:8: ( ID | WS )
        int alt5=2;
        int LA5_0 = input.LA(1);

        if ( (LA5_0=='\"'||LA5_0=='<') ) {
            alt5=1;
        }
        else if ( ((LA5_0 >= '\t' && LA5_0 <= '\n')||LA5_0=='\r'||LA5_0==' ') ) {
            alt5=2;
        }
        else {
            NoViableAltException nvae =
                new NoViableAltException("", 5, 0, input);

            throw nvae;

        }
        switch (alt5) {
            case 1 :
                // /home/waberto/Documents/COMP/TP1_AST/ast.g:1:10: ID
                {
                mID(); 


                }
                break;
            case 2 :
                // /home/waberto/Documents/COMP/TP1_AST/ast.g:1:13: WS
                {
                mWS(); 


                }
                break;

        }

    }


 

}