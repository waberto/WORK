// $ANTLR 3.5.2 Grammaire.g 2016-10-13 23:03:17

import java.util.HashMap;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class GrammaireParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ID", "WS", "'\"'", "','", "'.'", 
		"';'", "'<'", "'>'"
	};
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
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public GrammaireParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public GrammaireParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return GrammaireParser.tokenNames; }
	@Override public String getGrammarFileName() { return "Grammaire.g"; }


	/** Map variable name to Integer object holding value */
	HashMap memory = new HashMap();



	// $ANTLR start "doc"
	// Grammaire.g:13:1: doc : sujets ;
	public final void doc() throws RecognitionException {
		try {
			// Grammaire.g:13:4: ( sujets )
			// Grammaire.g:13:6: sujets
			{
			pushFollow(FOLLOW_sujets_in_doc23);
			sujets();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "doc"



	// $ANTLR start "sujets"
	// Grammaire.g:15:1: sujets : ( sujet sujets |);
	public final void sujets() throws RecognitionException {
		try {
			// Grammaire.g:15:7: ( sujet sujets |)
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==10) ) {
				alt1=1;
			}
			else if ( (LA1_0==EOF) ) {
				alt1=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}

			switch (alt1) {
				case 1 :
					// Grammaire.g:15:9: sujet sujets
					{
					pushFollow(FOLLOW_sujet_in_sujets47);
					sujet();
					state._fsp--;

					pushFollow(FOLLOW_sujets_in_sujets49);
					sujets();
					state._fsp--;

					}
					break;
				case 2 :
					// Grammaire.g:15:25: 
					{
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "sujets"



	// $ANTLR start "sujet"
	// Grammaire.g:17:1: sujet : entite predicats '.' ;
	public final void sujet() throws RecognitionException {
		try {
			// Grammaire.g:17:6: ( entite predicats '.' )
			// Grammaire.g:17:8: entite predicats '.'
			{
			pushFollow(FOLLOW_entite_in_sujet60);
			entite();
			state._fsp--;

			pushFollow(FOLLOW_predicats_in_sujet62);
			predicats();
			state._fsp--;

			match(input,8,FOLLOW_8_in_sujet64); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "sujet"



	// $ANTLR start "predicats"
	// Grammaire.g:19:1: predicats : ( predicat ';' predicats |);
	public final void predicats() throws RecognitionException {
		try {
			// Grammaire.g:19:10: ( predicat ';' predicats |)
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==10) ) {
				alt2=1;
			}
			else if ( (LA2_0==8) ) {
				alt2=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// Grammaire.g:19:12: predicat ';' predicats
					{
					pushFollow(FOLLOW_predicat_in_predicats71);
					predicat();
					state._fsp--;

					match(input,9,FOLLOW_9_in_predicats73); 
					pushFollow(FOLLOW_predicats_in_predicats75);
					predicats();
					state._fsp--;

					}
					break;
				case 2 :
					// Grammaire.g:19:36: 
					{
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "predicats"



	// $ANTLR start "predicat"
	// Grammaire.g:23:1: predicat : entite objets ;
	public final void predicat() throws RecognitionException {
		try {
			// Grammaire.g:23:9: ( entite objets )
			// Grammaire.g:23:11: entite objets
			{
			pushFollow(FOLLOW_entite_in_predicat86);
			entite();
			state._fsp--;

			pushFollow(FOLLOW_objets_in_predicat88);
			objets();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "predicat"



	// $ANTLR start "objets"
	// Grammaire.g:25:1: objets : ( objet ',' objets |);
	public final void objets() throws RecognitionException {
		try {
			// Grammaire.g:25:7: ( objet ',' objets |)
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==6||LA3_0==10) ) {
				alt3=1;
			}
			else if ( (LA3_0==9) ) {
				alt3=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// Grammaire.g:25:9: objet ',' objets
					{
					pushFollow(FOLLOW_objet_in_objets96);
					objet();
					state._fsp--;

					match(input,7,FOLLOW_7_in_objets98); 
					pushFollow(FOLLOW_objets_in_objets100);
					objets();
					state._fsp--;

					}
					break;
				case 2 :
					// Grammaire.g:25:28: 
					{
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "objets"



	// $ANTLR start "objet"
	// Grammaire.g:29:1: objet : ( entite | texte );
	public final void objet() throws RecognitionException {
		try {
			// Grammaire.g:29:6: ( entite | texte )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==10) ) {
				alt4=1;
			}
			else if ( (LA4_0==6) ) {
				alt4=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// Grammaire.g:29:8: entite
					{
					pushFollow(FOLLOW_entite_in_objet112);
					entite();
					state._fsp--;

					}
					break;
				case 2 :
					// Grammaire.g:29:17: texte
					{
					pushFollow(FOLLOW_texte_in_objet116);
					texte();
					state._fsp--;

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "objet"



	// $ANTLR start "entite"
	// Grammaire.g:32:1: entite : '<' ID '>' ;
	public final void entite() throws RecognitionException {
		try {
			// Grammaire.g:32:7: ( '<' ID '>' )
			// Grammaire.g:32:9: '<' ID '>'
			{
			match(input,10,FOLLOW_10_in_entite125); 
			match(input,ID,FOLLOW_ID_in_entite126); 
			match(input,11,FOLLOW_11_in_entite127); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "entite"



	// $ANTLR start "texte"
	// Grammaire.g:34:1: texte : '\"' ( ID )+ '\"' ;
	public final void texte() throws RecognitionException {
		try {
			// Grammaire.g:34:6: ( '\"' ( ID )+ '\"' )
			// Grammaire.g:34:8: '\"' ( ID )+ '\"'
			{
			match(input,6,FOLLOW_6_in_texte134); 
			// Grammaire.g:34:11: ( ID )+
			int cnt5=0;
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==ID) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// Grammaire.g:34:11: ID
					{
					match(input,ID,FOLLOW_ID_in_texte135); 
					}
					break;

				default :
					if ( cnt5 >= 1 ) break loop5;
					EarlyExitException eee = new EarlyExitException(5, input);
					throw eee;
				}
				cnt5++;
			}

			match(input,6,FOLLOW_6_in_texte137); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "texte"

	// Delegated rules



	public static final BitSet FOLLOW_sujets_in_doc23 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_sujet_in_sujets47 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_sujets_in_sujets49 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_entite_in_sujet60 = new BitSet(new long[]{0x0000000000000500L});
	public static final BitSet FOLLOW_predicats_in_sujet62 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_8_in_sujet64 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_predicat_in_predicats71 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_predicats73 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_predicats_in_predicats75 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_entite_in_predicat86 = new BitSet(new long[]{0x0000000000000440L});
	public static final BitSet FOLLOW_objets_in_predicat88 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_objet_in_objets96 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_7_in_objets98 = new BitSet(new long[]{0x0000000000000440L});
	public static final BitSet FOLLOW_objets_in_objets100 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_entite_in_objet112 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_texte_in_objet116 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_entite125 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ID_in_entite126 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_11_in_entite127 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_6_in_texte134 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ID_in_texte135 = new BitSet(new long[]{0x0000000000000050L});
	public static final BitSet FOLLOW_6_in_texte137 = new BitSet(new long[]{0x0000000000000002L});
}
