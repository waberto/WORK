grammar Grammaire;

@header {
import java.util.HashMap;
}

@members {
/** Map variable name to Integer object holding value */
HashMap memory = new HashMap();
}

/** Analyseur syntaxique */
doc: sujets ;
                
sujets returns [String name]
	: sujet '.' sujets[$sujet.name] |  ;

sujet returns [String name]
	: entite[$entite.name] predicats[$sujet.name]
	;

predicats[String sujet]
	: predicat[$sujet] suite_predicat[$sujet] 
	;

suite_predicat[String sujet]
	: ';' predicats[$sujet] |  
	; 

predicat[String sujet]
	: entite[$sujet, $predicat] objets[$sujet, $ID.texte]
	;

objets[String sujet, String predicat]
	: objet[$sujet, $predicat] suite_objet[$sujet, $predicat]
	;

suite_objet[String sujet, String predicat]
	: ',' objets[$sujet, $predicat] | 
	 ;

objet[String sujet, String predicat] 
	: entite {System.out.println(sujet + " " + predicat + " " + $entite.name ".");}
	 |texte {System.out.println(sujet + " " + predicat + " " + $texte.name ".");} 
	;


entite returns [String name]  
	:'<'ID'>' {$name = '<' + $ID.entite + '>';}
	;

texte returns [String name]
	: '"'ID+'"' {$name = '"' + $ID.texte + '"';}
	; 

/** Analyseur lexicale */
ID  :   ('a'..'z'|'A'..'Z'|'0'..'9'|'-'|'&')+ ;
WS  :   (' '|'\t'|'\r'|'\n')+ {skip();} ;

