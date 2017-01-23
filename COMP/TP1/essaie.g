grammar Grammaire;

@header {
import java.util.HashMap;
}

@members {
/** Map variable name to Integer object holding value */
HashMap memory = new HashMap();
}

/** Analyse syntaxique */


objet: entite | texte ;


entite: ID;

texte: TEXT; 

/** Analyse lexicale */
ID  :   '<'('a'..'z'|'A'..'Z'|'0'..'9')+'>' ;
TEXT :  '"'('a'..'z'|'A'..'Z'|'0'..'9')+'"' ;
WS  :   (' '|'\t'|'\r'|'\n')+ {skip();} ;

