// $ANTLR 3.5.2 Essaie.g 2016-10-10 11:43:32

import java.util.HashMap;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class EssaieParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ID", "TEXT", "WS", "','"
	};
	public static final int EOF=-1;
	public static final int T__7=7;
	public static final int ID=4;
	public static final int TEXT=5;
	public static final int WS=6;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public EssaieParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public EssaieParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return EssaieParser.tokenNames; }
	@Override public String getGrammarFileName() { return "Essaie.g"; }


	/** Map variable name to Integer object holding value */
	HashMap memory = new HashMap();



	// $ANTLR start "doc"
	// Essaie.g:14:1: doc : objets ;
	public final void doc() throws RecognitionException {
		try {
			// Essaie.g:14:4: ( objets )
			// Essaie.g:14:6: objets
			{
			pushFollow(FOLLOW_objets_in_doc24);
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
	// $ANTLR end "doc"



	// $ANTLR start "objets"
	// Essaie.g:16:1: objets : objet suite_objet ;
	public final void objets() throws RecognitionException {
		try {
			// Essaie.g:16:7: ( objet suite_objet )
			// Essaie.g:16:9: objet suite_objet
			{
			pushFollow(FOLLOW_objet_in_objets31);
			objet();
			state._fsp--;

			pushFollow(FOLLOW_suite_objet_in_objets33);
			suite_objet();
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
	// Essaie.g:18:1: suite_objet : ( WS ',' WS objets |);
	public final void suite_objet() throws RecognitionException {
		try {
			// Essaie.g:18:12: ( WS ',' WS objets |)
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==WS) ) {
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
					// Essaie.g:18:14: WS ',' WS objets
					{
					match(input,WS,FOLLOW_WS_in_suite_objet41); 
					match(input,7,FOLLOW_7_in_suite_objet42); 
					match(input,WS,FOLLOW_WS_in_suite_objet43); 
					pushFollow(FOLLOW_objets_in_suite_objet45);
					objets();
					state._fsp--;

					}
					break;
				case 2 :
					// Essaie.g:18:32: 
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
	// Essaie.g:20:1: objet : ( entite | texte );
	public final void objet() throws RecognitionException {
		try {
			// Essaie.g:20:6: ( entite | texte )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==ID) ) {
				alt2=1;
			}
			else if ( (LA2_0==TEXT) ) {
				alt2=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// Essaie.g:20:8: entite
					{
					pushFollow(FOLLOW_entite_in_objet56);
					entite();
					state._fsp--;

					}
					break;
				case 2 :
					// Essaie.g:20:17: texte
					{
					pushFollow(FOLLOW_texte_in_objet60);
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
	// Essaie.g:23:1: entite : ID ;
	public final void entite() throws RecognitionException {
		try {
			// Essaie.g:23:7: ( ID )
			// Essaie.g:23:9: ID
			{
			match(input,ID,FOLLOW_ID_in_entite69); 
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
	// Essaie.g:25:1: texte : TEXT ;
	public final void texte() throws RecognitionException {
		try {
			// Essaie.g:25:6: ( TEXT )
			// Essaie.g:25:8: TEXT
			{
			match(input,TEXT,FOLLOW_TEXT_in_texte76); 
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



	public static final BitSet FOLLOW_objets_in_doc24 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_objet_in_objets31 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_suite_objet_in_objets33 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WS_in_suite_objet41 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_7_in_suite_objet42 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_WS_in_suite_objet43 = new BitSet(new long[]{0x0000000000000030L});
	public static final BitSet FOLLOW_objets_in_suite_objet45 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_entite_in_objet56 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_texte_in_objet60 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_entite69 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TEXT_in_texte76 = new BitSet(new long[]{0x0000000000000002L});
}
