// $ANTLR 3.4 /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g 2016-10-13 18:26:59

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class Grammaire_NtripleLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__6=6;
    public static final int T__7=7;
    public static final int T__8=8;
    public static final int T__9=9;
    public static final int T__10=10;
    public static final int T__11=11;
    public static final int ID=4;
    public static final int WS=5;

    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public Grammaire_NtripleLexer() {} 
    public Grammaire_NtripleLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public Grammaire_NtripleLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "/home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g"; }

    // $ANTLR start "T__6"
    public final void mT__6() throws RecognitionException {
        try {
            int _type = T__6;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:2:6: ( '\"' )
            // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:2:8: '\"'
            {
            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__6"

    // $ANTLR start "T__7"
    public final void mT__7() throws RecognitionException {
        try {
            int _type = T__7;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:3:6: ( ',' )
            // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:3:8: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__7"

    // $ANTLR start "T__8"
    public final void mT__8() throws RecognitionException {
        try {
            int _type = T__8;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:4:6: ( '.' )
            // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:4:8: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__8"

    // $ANTLR start "T__9"
    public final void mT__9() throws RecognitionException {
        try {
            int _type = T__9;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:5:6: ( ';' )
            // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:5:8: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__9"

    // $ANTLR start "T__10"
    public final void mT__10() throws RecognitionException {
        try {
            int _type = T__10;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:6:7: ( '<' )
            // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:6:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__10"

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:7:7: ( '>' )
            // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:7:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__11"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:58:5: ( ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '-' | '&' )+ )
            // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:58:9: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '-' | '&' )+
            {
            // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:58:9: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '-' | '&' )+
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
            	    // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:
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
            // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:58:5: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:58:9: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:58:9: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= '\t' && LA2_0 <= '\n')||LA2_0=='\r'||LA2_0==' ') ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:
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
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
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
        // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:1:8: ( T__6 | T__7 | T__8 | T__9 | T__10 | T__11 | ID | WS )
        int alt3=8;
        switch ( input.LA(1) ) {
        case '\"':
            {
            alt3=1;
            }
            break;
        case ',':
            {
            alt3=2;
            }
            break;
        case '.':
            {
            alt3=3;
            }
            break;
        case ';':
            {
            alt3=4;
            }
            break;
        case '<':
            {
            alt3=5;
            }
            break;
        case '>':
            {
            alt3=6;
            }
            break;
        case '&':
        case '-':
        case '0':
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
        case 'A':
        case 'B':
        case 'C':
        case 'D':
        case 'E':
        case 'F':
        case 'G':
        case 'H':
        case 'I':
        case 'J':
        case 'K':
        case 'L':
        case 'M':
        case 'N':
        case 'O':
        case 'P':
        case 'Q':
        case 'R':
        case 'S':
        case 'T':
        case 'U':
        case 'V':
        case 'W':
        case 'X':
        case 'Y':
        case 'Z':
        case 'a':
        case 'b':
        case 'c':
        case 'd':
        case 'e':
        case 'f':
        case 'g':
        case 'h':
        case 'i':
        case 'j':
        case 'k':
        case 'l':
        case 'm':
        case 'n':
        case 'o':
        case 'p':
        case 'q':
        case 'r':
        case 's':
        case 't':
        case 'u':
        case 'v':
        case 'w':
        case 'x':
        case 'y':
        case 'z':
            {
            alt3=7;
            }
            break;
        case '\t':
        case '\n':
        case '\r':
        case ' ':
            {
            alt3=8;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 3, 0, input);

            throw nvae;

        }

        switch (alt3) {
            case 1 :
                // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:1:10: T__6
                {
                mT__6(); 


                }
                break;
            case 2 :
                // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:1:15: T__7
                {
                mT__7(); 


                }
                break;
            case 3 :
                // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:1:20: T__8
                {
                mT__8(); 


                }
                break;
            case 4 :
                // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:1:25: T__9
                {
                mT__9(); 


                }
                break;
            case 5 :
                // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:1:30: T__10
                {
                mT__10(); 


                }
                break;
            case 6 :
                // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:1:36: T__11
                {
                mT__11(); 


                }
                break;
            case 7 :
                // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:1:42: ID
                {
                mID(); 


                }
                break;
            case 8 :
                // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:1:45: WS
                {
                mWS(); 


                }
                break;

        }

    }


 

}