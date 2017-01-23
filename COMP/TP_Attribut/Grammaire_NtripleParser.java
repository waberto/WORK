// $ANTLR 3.5.2 Grammaire_Ntriple.g 2016-10-13 22:27:58

import java.util.HashMap;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class Grammaire_NtripleParser extends Parser {
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


	public Grammaire_NtripleParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public Grammaire_NtripleParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return Grammaire_NtripleParser.tokenNames; }
	@Override public String getGrammarFileName() { return "Grammaire_Ntriple.g"; }


	/** Map variable name to Integer object holding value */
	HashMap memory = new HashMap();



	// $ANTLR start "doc"
	// Grammaire_Ntriple.g:13:1: doc : sujets ;
	public final void doc() throws RecognitionException {
		try {
			// Grammaire_Ntriple.g:13:4: ( sujets )
			// Grammaire_Ntriple.g:13:6: sujets
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
	// Grammaire_Ntriple.g:15:1: sujets : ( sujet '.' sujets |);
	public final void sujets() throws RecognitionException {
		try {
			// Grammaire_Ntriple.g:15:7: ( sujet '.' sujets |)
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
					// Grammaire_Ntriple.g:15:9: sujet '.' sujets
					{
					pushFollow(FOLLOW_sujet_in_sujets47);
					sujet();
					state._fsp--;

					match(input,8,FOLLOW_8_in_sujets49); 
					pushFollow(FOLLOW_sujets_in_sujets51);
					sujets();
					state._fsp--;

					}
					break;
				case 2 :
					// Grammaire_Ntriple.g:15:29: 
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
	// Grammaire_Ntriple.g:17:1: sujet : entite predicats[$entite.txt] ;
	public final void sujet() throws RecognitionException {
		String entite1 =null;

		try {
			// Grammaire_Ntriple.g:18:3: ( entite predicats[$entite.txt] )
			// Grammaire_Ntriple.g:18:3: entite predicats[$entite.txt]
			{
			pushFollow(FOLLOW_entite_in_sujet63);
			entite1=entite();
			state._fsp--;

			pushFollow(FOLLOW_predicats_in_sujet65);
			predicats(entite1);
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
	// $ANTLR end "sujet"



	// $ANTLR start "predicats"
	// Grammaire_Ntriple.g:20:1: predicats[String Sujet] : predicat[Sujet] suite_predicat[Sujet] ;
	public final void predicats(String Sujet) throws RecognitionException {
		try {
			// Grammaire_Ntriple.g:21:2: ( predicat[Sujet] suite_predicat[Sujet] )
			// Grammaire_Ntriple.g:21:4: predicat[Sujet] suite_predicat[Sujet]
			{
			pushFollow(FOLLOW_predicat_in_predicats77);
			predicat(Sujet);
			state._fsp--;

			pushFollow(FOLLOW_suite_predicat_in_predicats80);
			suite_predicat(Sujet);
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
	// $ANTLR end "predicats"



	// $ANTLR start "suite_predicat"
	// Grammaire_Ntriple.g:23:1: suite_predicat[String Sujet] : ( ';' predicats[Sujet] |);
	public final void suite_predicat(String Sujet) throws RecognitionException {
		try {
			// Grammaire_Ntriple.g:24:2: ( ';' predicats[Sujet] |)
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==9) ) {
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
					// Grammaire_Ntriple.g:24:4: ';' predicats[Sujet]
					{
					match(input,9,FOLLOW_9_in_suite_predicat92); 
					pushFollow(FOLLOW_predicats_in_suite_predicat94);
					predicats(Sujet);
					state._fsp--;

					}
					break;
				case 2 :
					// Grammaire_Ntriple.g:24:28: 
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
	// $ANTLR end "suite_predicat"



	// $ANTLR start "predicat"
	// Grammaire_Ntriple.g:26:1: predicat[String Sujet] : entite objets[Sujet, $entite.txt] ;
	public final void predicat(String Sujet) throws RecognitionException {
		String entite2 =null;

		try {
			// Grammaire_Ntriple.g:27:2: ( entite objets[Sujet, $entite.txt] )
			// Grammaire_Ntriple.g:27:4: entite objets[Sujet, $entite.txt]
			{
			pushFollow(FOLLOW_entite_in_predicat110);
			entite2=entite();
			state._fsp--;

			pushFollow(FOLLOW_objets_in_predicat112);
			objets(Sujet, entite2);
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
	// Grammaire_Ntriple.g:29:1: objets[String Sujet,String Predicat] : objet[Sujet, Predicat] suite_objet[Sujet, Predicat] ;
	public final void objets(String Sujet, String Predicat) throws RecognitionException {
		try {
			// Grammaire_Ntriple.g:29:39: ( objet[Sujet, Predicat] suite_objet[Sujet, Predicat] )
			// Grammaire_Ntriple.g:30:3: objet[Sujet, Predicat] suite_objet[Sujet, Predicat]
			{
			pushFollow(FOLLOW_objet_in_objets126);
			objet(Sujet, Predicat);
			state._fsp--;

			pushFollow(FOLLOW_suite_objet_in_objets129);
			suite_objet(Sujet, Predicat);
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
	// $ANTLR end "objets"



	// $ANTLR start "suite_objet"
	// Grammaire_Ntriple.g:32:1: suite_objet[String Sujet,String Predicat] : ( ',' objets[Sujet, Predicat] |);
	public final void suite_objet(String Sujet, String Predicat) throws RecognitionException {
		try {
			// Grammaire_Ntriple.g:33:2: ( ',' objets[Sujet, Predicat] |)
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==7) ) {
				alt3=1;
			}
			else if ( ((LA3_0 >= 8 && LA3_0 <= 9)) ) {
				alt3=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// Grammaire_Ntriple.g:33:4: ',' objets[Sujet, Predicat]
					{
					match(input,7,FOLLOW_7_in_suite_objet140); 
					pushFollow(FOLLOW_objets_in_suite_objet142);
					objets(Sujet, Predicat);
					state._fsp--;

					}
					break;
				case 2 :
					// Grammaire_Ntriple.g:33:35: 
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
	// $ANTLR end "suite_objet"



	// $ANTLR start "objet"
	// Grammaire_Ntriple.g:35:1: objet[String Sujet, String Predicat] : ( entite | texte );
	public final void objet(String Sujet, String Predicat) throws RecognitionException {
		String entite3 =null;
		String texte4 =null;

		try {
			// Grammaire_Ntriple.g:36:2: ( entite | texte )
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
					// Grammaire_Ntriple.g:36:4: entite
					{
					pushFollow(FOLLOW_entite_in_objet158);
					entite3=entite();
					state._fsp--;

					System.out.println( Sujet + " "   + Predicat + " "  +   entite3 + ".");
					}
					break;
				case 2 :
					// Grammaire_Ntriple.g:38:3: texte
					{
					pushFollow(FOLLOW_texte_in_objet168);
					texte4=texte();
					state._fsp--;

					System.out.println( Sujet  + " " + Predicat  + " "  + texte4 + ".");
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
	// Grammaire_Ntriple.g:41:1: entite returns [String txt] : '<' ID '>' ;
	public final String entite() throws RecognitionException {
		String txt = null;


		Token ID5=null;

		try {
			// Grammaire_Ntriple.g:41:28: ( '<' ID '>' )
			// Grammaire_Ntriple.g:42:2: '<' ID '>'
			{
			match(input,10,FOLLOW_10_in_entite185); 
			ID5=(Token)match(input,ID,FOLLOW_ID_in_entite186); 
			match(input,11,FOLLOW_11_in_entite187); 
			txt = '<' + (ID5!=null?ID5.getText():null) + '>';
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return txt;
	}
	// $ANTLR end "entite"



	// $ANTLR start "texte"
	// Grammaire_Ntriple.g:45:1: texte returns [String txt] : '\"' ( ID )+ '\"' ;
	public final String texte() throws RecognitionException {
		String txt = null;


		Token ID6=null;

		try {
			// Grammaire_Ntriple.g:46:2: ( '\"' ( ID )+ '\"' )
			// Grammaire_Ntriple.g:46:4: '\"' ( ID )+ '\"'
			{
			match(input,6,FOLLOW_6_in_texte204); 
			// Grammaire_Ntriple.g:46:7: ( ID )+
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
					// Grammaire_Ntriple.g:46:7: ID
					{
					ID6=(Token)match(input,ID,FOLLOW_ID_in_texte205); 
					}
					break;

				default :
					if ( cnt5 >= 1 ) break loop5;
					EarlyExitException eee = new EarlyExitException(5, input);
					throw eee;
				}
				cnt5++;
			}

			match(input,6,FOLLOW_6_in_texte207); 
			txt = '"' + (ID6!=null?ID6.getText():null) + '"';
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return txt;
	}
	// $ANTLR end "texte"

	// Delegated rules



	public static final BitSet FOLLOW_sujets_in_doc23 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_sujet_in_sujets47 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_8_in_sujets49 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_sujets_in_sujets51 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_entite_in_sujet63 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_predicats_in_sujet65 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_predicat_in_predicats77 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_suite_predicat_in_predicats80 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_9_in_suite_predicat92 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_predicats_in_suite_predicat94 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_entite_in_predicat110 = new BitSet(new long[]{0x0000000000000440L});
	public static final BitSet FOLLOW_objets_in_predicat112 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_objet_in_objets126 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_suite_objet_in_objets129 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_7_in_suite_objet140 = new BitSet(new long[]{0x0000000000000440L});
	public static final BitSet FOLLOW_objets_in_suite_objet142 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_entite_in_objet158 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_texte_in_objet168 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_entite185 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ID_in_entite186 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_11_in_entite187 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_6_in_texte204 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ID_in_texte205 = new BitSet(new long[]{0x0000000000000050L});
	public static final BitSet FOLLOW_6_in_texte207 = new BitSet(new long[]{0x0000000000000002L});
}
