grammar Essaie;

@header {
import java.util.HashMap;
}

@members {
/** Map variable name to Integer object holding value */
HashMap memory = new HashMap();
}

/** Analyse syntaxique */

doc: objets;

objets: objet suite_objet ;

suite_objet: WS','WS objets |  ;

objet: entite | texte ;


entite: ID;

texte: TEXT; 

/** Analyse lexicale */
ID  :   '<'('a'..'z'|'A'..'Z'|'0'..'9')+'>' ;
TEXT :  '"'('a'..'z'|'A'..'Z'|'0'..'9')+'"' ;
WS  :   (' '|'\t'|'\r'|'\n')+ {skip();} ;


