// $ANTLR 3.4 /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g 2016-10-13 18:26:59

import java.util.HashMap;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.debug.*;
import java.io.IOException;
@SuppressWarnings({"all", "warnings", "unchecked"})
public class Grammaire_NtripleParser extends DebugParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ID", "WS", "'\"'", "','", "'.'", "';'", "'<'", "'>'"
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


public static final String[] ruleNames = new String[] {
    "invalidRule", "sujet", "objets", "entite", "sujets", "predicats", "suite_objet", 
    "doc", "objet", "texte", "predicat", "suite_predicat"
};

public static final boolean[] decisionCanBacktrack = new boolean[] {
    false, // invalid decision
    false, false, false, false, false
};

 
    public int ruleLevel = 0;
    public int getRuleLevel() { return ruleLevel; }
    public void incRuleLevel() { ruleLevel++; }
    public void decRuleLevel() { ruleLevel--; }
    public Grammaire_NtripleParser(TokenStream input) {
        this(input, DebugEventSocketProxy.DEFAULT_DEBUGGER_PORT, new RecognizerSharedState());
    }
    public Grammaire_NtripleParser(TokenStream input, int port, RecognizerSharedState state) {
        super(input, state);
        DebugEventSocketProxy proxy =
            new DebugEventSocketProxy(this, port, null);

        setDebugListener(proxy);
        try {
            proxy.handshake();
        }
        catch (IOException ioe) {
            reportError(ioe);
        }
    }

public Grammaire_NtripleParser(TokenStream input, DebugEventListener dbg) {
    super(input, dbg, new RecognizerSharedState());
}

protected boolean evalPredicate(boolean result, String predicate) {
    dbg.semanticPredicate(result, predicate);
    return result;
}

    public String[] getTokenNames() { return Grammaire_NtripleParser.tokenNames; }
    public String getGrammarFileName() { return "/home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g"; }


    /** Map variable name to Integer object holding value */
    HashMap memory = new HashMap();



    // $ANTLR start "doc"
    // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:15:1: doc : sujets ;
    public final void doc() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "doc");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(15, 0);

        try {
            // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:15:4: ( sujets )
            dbg.enterAlt(1);

            // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:15:6: sujets
            {
            dbg.location(15,6);
            pushFollow(FOLLOW_sujets_in_doc27);
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
        dbg.location(15, 12);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "doc");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "doc"



    // $ANTLR start "sujets"
    // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:17:1: sujets : ( sujet '.' sujets |);
    public final void sujets() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "sujets");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(17, 0);

        try {
            // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:18:2: ( sujet '.' sujets |)
            int alt1=2;
            try { dbg.enterDecision(1, decisionCanBacktrack[1]);

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

                dbg.recognitionException(nvae);
                throw nvae;

            }
            } finally {dbg.exitDecision(1);}

            switch (alt1) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:18:4: sujet '.' sujets
                    {
                    dbg.location(18,4);
                    pushFollow(FOLLOW_sujet_in_sujets54);
                    sujet();

                    state._fsp--;

                    dbg.location(18,10);
                    match(input,8,FOLLOW_8_in_sujets56); 
                    dbg.location(18,14);
                    pushFollow(FOLLOW_sujets_in_sujets58);
                    sujets();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:19:2: 
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
        dbg.location(19, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "sujets");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "sujets"



    // $ANTLR start "sujet"
    // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:21:1: sujet : entite predicats[$entite.txt] ;
    public final void sujet() throws RecognitionException {
        String entite1 =null;


        try { dbg.enterRule(getGrammarFileName(), "sujet");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(21, 0);

        try {
            // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:22:2: ( entite predicats[$entite.txt] )
            dbg.enterAlt(1);

            // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:22:4: entite predicats[$entite.txt]
            {
            dbg.location(22,4);
            pushFollow(FOLLOW_entite_in_sujet72);
            entite1=entite();

            state._fsp--;

            dbg.location(22,11);
            pushFollow(FOLLOW_predicats_in_sujet74);
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
        dbg.location(23, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "sujet");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "sujet"



    // $ANTLR start "predicats"
    // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:25:1: predicats[String Sujet] : predicat[Sujet] suite_predicat[Sujet] ;
    public final void predicats(String Sujet) throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "predicats");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(25, 0);

        try {
            // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:26:2: ( predicat[Sujet] suite_predicat[Sujet] )
            dbg.enterAlt(1);

            // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:26:4: predicat[Sujet] suite_predicat[Sujet]
            {
            dbg.location(26,4);
            pushFollow(FOLLOW_predicat_in_predicats88);
            predicat(Sujet);

            state._fsp--;

            dbg.location(26,20);
            pushFollow(FOLLOW_suite_predicat_in_predicats91);
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
        dbg.location(27, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "predicats");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "predicats"



    // $ANTLR start "suite_predicat"
    // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:29:1: suite_predicat[String Sujet] : ( ';' predicats[Sujet] |);
    public final void suite_predicat(String Sujet) throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "suite_predicat");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(29, 0);

        try {
            // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:30:2: ( ';' predicats[Sujet] |)
            int alt2=2;
            try { dbg.enterDecision(2, decisionCanBacktrack[2]);

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

                dbg.recognitionException(nvae);
                throw nvae;

            }
            } finally {dbg.exitDecision(2);}

            switch (alt2) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:30:4: ';' predicats[Sujet]
                    {
                    dbg.location(30,4);
                    match(input,9,FOLLOW_9_in_suite_predicat105); 
                    dbg.location(30,8);
                    pushFollow(FOLLOW_predicats_in_suite_predicat107);
                    predicats(Sujet);

                    state._fsp--;


                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:31:2: 
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
        dbg.location(31, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "suite_predicat");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "suite_predicat"



    // $ANTLR start "predicat"
    // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:33:1: predicat[String Sujet] : entite objets[Sujet, $entite.txt] ;
    public final void predicat(String Sujet) throws RecognitionException {
        String entite2 =null;


        try { dbg.enterRule(getGrammarFileName(), "predicat");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(33, 0);

        try {
            // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:34:2: ( entite objets[Sujet, $entite.txt] )
            dbg.enterAlt(1);

            // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:34:4: entite objets[Sujet, $entite.txt]
            {
            dbg.location(34,4);
            pushFollow(FOLLOW_entite_in_predicat125);
            entite2=entite();

            state._fsp--;

            dbg.location(34,11);
            pushFollow(FOLLOW_objets_in_predicat127);
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
        dbg.location(35, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "predicat");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "predicat"



    // $ANTLR start "objets"
    // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:37:1: objets[String Sujet,String Predicat] : objet[Sujet, Predicat] suite_objet[Sujet, Predicat] ;
    public final void objets(String Sujet, String Predicat) throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "objets");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(37, 0);

        try {
            // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:37:39: ( objet[Sujet, Predicat] suite_objet[Sujet, Predicat] )
            dbg.enterAlt(1);

            // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:38:3: objet[Sujet, Predicat] suite_objet[Sujet, Predicat]
            {
            dbg.location(38,3);
            pushFollow(FOLLOW_objet_in_objets143);
            objet(Sujet, Predicat);

            state._fsp--;

            dbg.location(38,26);
            pushFollow(FOLLOW_suite_objet_in_objets146);
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
        dbg.location(38, 53);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "objets");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "objets"



    // $ANTLR start "suite_objet"
    // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:40:1: suite_objet[String Sujet,String Predicat] : ( ',' objets[Sujet, Predicat] |);
    public final void suite_objet(String Sujet, String Predicat) throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "suite_objet");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(40, 0);

        try {
            // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:41:2: ( ',' objets[Sujet, Predicat] |)
            int alt3=2;
            try { dbg.enterDecision(3, decisionCanBacktrack[3]);

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

                dbg.recognitionException(nvae);
                throw nvae;

            }
            } finally {dbg.exitDecision(3);}

            switch (alt3) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:41:4: ',' objets[Sujet, Predicat]
                    {
                    dbg.location(41,4);
                    match(input,7,FOLLOW_7_in_suite_objet157); 
                    dbg.location(41,8);
                    pushFollow(FOLLOW_objets_in_suite_objet159);
                    objets(Sujet, Predicat);

                    state._fsp--;


                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:41:35: 
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
        dbg.location(41, 34);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "suite_objet");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "suite_objet"



    // $ANTLR start "objet"
    // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:43:1: objet[String Sujet, String Predicat] : ( entite | texte );
    public final void objet(String Sujet, String Predicat) throws RecognitionException {
        String entite3 =null;

        String texte4 =null;


        try { dbg.enterRule(getGrammarFileName(), "objet");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(43, 0);

        try {
            // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:44:2: ( entite | texte )
            int alt4=2;
            try { dbg.enterDecision(4, decisionCanBacktrack[4]);

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

                dbg.recognitionException(nvae);
                throw nvae;

            }
            } finally {dbg.exitDecision(4);}

            switch (alt4) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:44:4: entite
                    {
                    dbg.location(44,4);
                    pushFollow(FOLLOW_entite_in_objet175);
                    entite3=entite();

                    state._fsp--;

                    dbg.location(44,11);
                    System.out.println( Sujet + " "   + Predicat + " "  +   entite3 + ".");

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:46:3: texte
                    {
                    dbg.location(46,3);
                    pushFollow(FOLLOW_texte_in_objet185);
                    texte4=texte();

                    state._fsp--;

                    dbg.location(46,9);
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
        dbg.location(47, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "objet");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "objet"



    // $ANTLR start "entite"
    // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:49:1: entite returns [String txt] : '<' ID '>' ;
    public final String entite() throws RecognitionException {
        String txt = null;


        Token ID5=null;

        try { dbg.enterRule(getGrammarFileName(), "entite");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(49, 0);

        try {
            // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:49:28: ( '<' ID '>' )
            dbg.enterAlt(1);

            // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:50:2: '<' ID '>'
            {
            dbg.location(50,2);
            match(input,10,FOLLOW_10_in_entite202); 
            dbg.location(50,5);
            ID5=(Token)match(input,ID,FOLLOW_ID_in_entite203); 
            dbg.location(50,7);
            match(input,11,FOLLOW_11_in_entite204); 
            dbg.location(50,11);
            txt = '<' + ID5.texte + '>';

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(51, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "entite");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return txt;
    }
    // $ANTLR end "entite"



    // $ANTLR start "texte"
    // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:53:1: texte returns [String txt] : '\"' ( ID )+ '\"' ;
    public final String texte() throws RecognitionException {
        String txt = null;


        Token ID6=null;

        try { dbg.enterRule(getGrammarFileName(), "texte");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(53, 0);

        try {
            // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:54:2: ( '\"' ( ID )+ '\"' )
            dbg.enterAlt(1);

            // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:54:4: '\"' ( ID )+ '\"'
            {
            dbg.location(54,4);
            match(input,6,FOLLOW_6_in_texte221); 
            dbg.location(54,7);
            // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:54:7: ( ID )+
            int cnt5=0;
            try { dbg.enterSubRule(5);

            loop5:
            do {
                int alt5=2;
                try { dbg.enterDecision(5, decisionCanBacktrack[5]);

                int LA5_0 = input.LA(1);

                if ( (LA5_0==ID) ) {
                    alt5=1;
                }


                } finally {dbg.exitDecision(5);}

                switch (alt5) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/waberto/Documents/COMP/TP_Attribut/Grammaire_Ntriple.g:54:7: ID
            	    {
            	    dbg.location(54,7);
            	    ID6=(Token)match(input,ID,FOLLOW_ID_in_texte222); 

            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        dbg.recognitionException(eee);

                        throw eee;
                }
                cnt5++;
            } while (true);
            } finally {dbg.exitSubRule(5);}

            dbg.location(54,10);
            match(input,6,FOLLOW_6_in_texte224); 
            dbg.location(54,15);
            txt = '"' + ID6.texte + '"';

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(54, 45);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "texte");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return txt;
    }
    // $ANTLR end "texte"

    // Delegated rules


 

    public static final BitSet FOLLOW_sujets_in_doc27 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sujet_in_sujets54 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8_in_sujets56 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_sujets_in_sujets58 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_entite_in_sujet72 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_predicats_in_sujet74 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_predicat_in_predicats88 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_suite_predicat_in_predicats91 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_9_in_suite_predicat105 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_predicats_in_suite_predicat107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_entite_in_predicat125 = new BitSet(new long[]{0x0000000000000440L});
    public static final BitSet FOLLOW_objets_in_predicat127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_objet_in_objets143 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_suite_objet_in_objets146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_7_in_suite_objet157 = new BitSet(new long[]{0x0000000000000440L});
    public static final BitSet FOLLOW_objets_in_suite_objet159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_entite_in_objet175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_texte_in_objet185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_entite202 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_entite203 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_entite204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_6_in_texte221 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_texte222 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_6_in_texte224 = new BitSet(new long[]{0x0000000000000002L});

}