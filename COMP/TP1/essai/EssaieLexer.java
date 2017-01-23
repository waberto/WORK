// $ANTLR 3.5.2 Essaie.g 2016-10-10 11:43:32

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class EssaieLexer extends Lexer {
	public static final int EOF=-1;
	public static final int T__7=7;
	public static final int ID=4;
	public static final int TEXT=5;
	public static final int WS=6;

	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public EssaieLexer() {} 
	public EssaieLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public EssaieLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "Essaie.g"; }

	// $ANTLR start "T__7"
	public final void mT__7() throws RecognitionException {
		try {
			int _type = T__7;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Essaie.g:2:6: ( ',' )
			// Essaie.g:2:8: ','
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

	// $ANTLR start "ID"
	public final void mID() throws RecognitionException {
		try {
			int _type = ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Essaie.g:29:5: ( '<' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )+ '>' )
			// Essaie.g:29:9: '<' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )+ '>'
			{
			match('<'); 
			// Essaie.g:29:12: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// Essaie.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
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
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			match('>'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ID"

	// $ANTLR start "TEXT"
	public final void mTEXT() throws RecognitionException {
		try {
			int _type = TEXT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Essaie.g:29:6: ( '\"' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )+ '\"' )
			// Essaie.g:29:9: '\"' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )+ '\"'
			{
			match('\"'); 
			// Essaie.g:29:12: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )+
			int cnt2=0;
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( ((LA2_0 >= '0' && LA2_0 <= '9')||(LA2_0 >= 'A' && LA2_0 <= 'Z')||(LA2_0 >= 'a' && LA2_0 <= 'z')) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// Essaie.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
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
					EarlyExitException eee = new EarlyExitException(2, input);
					throw eee;
				}
				cnt2++;
			}

			match('\"'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TEXT"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Essaie.g:30:5: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
			// Essaie.g:30:9: ( ' ' | '\\t' | '\\r' | '\\n' )+
			{
			// Essaie.g:30:9: ( ' ' | '\\t' | '\\r' | '\\n' )+
			int cnt3=0;
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( ((LA3_0 >= '\t' && LA3_0 <= '\n')||LA3_0=='\r'||LA3_0==' ') ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// Essaie.g:
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
					if ( cnt3 >= 1 ) break loop3;
					EarlyExitException eee = new EarlyExitException(3, input);
					throw eee;
				}
				cnt3++;
			}

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

	@Override
	public void mTokens() throws RecognitionException {
		// Essaie.g:1:8: ( T__7 | ID | TEXT | WS )
		int alt4=4;
		switch ( input.LA(1) ) {
		case ',':
			{
			alt4=1;
			}
			break;
		case '<':
			{
			alt4=2;
			}
			break;
		case '\"':
			{
			alt4=3;
			}
			break;
		case '\t':
		case '\n':
		case '\r':
		case ' ':
			{
			alt4=4;
			}
			break;
		default:
			NoViableAltException nvae =
				new NoViableAltException("", 4, 0, input);
			throw nvae;
		}
		switch (alt4) {
			case 1 :
				// Essaie.g:1:10: T__7
				{
				mT__7(); 

				}
				break;
			case 2 :
				// Essaie.g:1:15: ID
				{
				mID(); 

				}
				break;
			case 3 :
				// Essaie.g:1:18: TEXT
				{
				mTEXT(); 

				}
				break;
			case 4 :
				// Essaie.g:1:23: WS
				{
				mWS(); 

				}
				break;

		}
	}



}
