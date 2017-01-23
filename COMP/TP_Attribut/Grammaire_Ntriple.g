grammar Grammaire_Ntriple;

@header {
import java.util.HashMap;
}

@members {
/** Map variable name to Integer object holding value */
HashMap memory = new HashMap();
}

/** Analyseur syntaxique */
doc: sujets ;
                
sujets: sujet '.' sujets |  ;

sujet
: entite predicats[$entite.txt] ;

predicats[String Sujet]
	: predicat[Sujet] suite_predicat[Sujet] ;

suite_predicat[String Sujet]
	: ';' predicats[Sujet] |  ; 

predicat[String Sujet]
	: entite objets[Sujet, $entite.txt] ;

objets[String Sujet,String Predicat]  :
	 objet[Sujet, Predicat] suite_objet[Sujet, Predicat];

suite_objet[String Sujet,String Predicat]
	: ',' objets[Sujet, Predicat] |  ;

objet[String Sujet, String Predicat]	
	: entite {System.out.println( Sujet + " "   + Predicat + " "  +   $entite.txt + ".");} 
	|
	 texte {System.out.println( Sujet  + " " + Predicat  + " "  + $texte.txt + ".");}
	;

entite returns [String txt]: 
	'<'ID'>' {$txt = '<' + $ID.text + '>';}
	;

texte returns [String txt]
	: '"'ID+'"'  {$txt = '"' + $ID.text + '"';}; 

/** Analyseur lexicale */
ID  :   ('a'..'z'|'A'..'Z'|'0'..'9'|'-'|'&')+ ;
WS  :   (' '|'\t'|'\r'|'\n')+ {skip();} ;
