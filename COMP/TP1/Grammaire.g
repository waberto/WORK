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
                
sujets: sujet sujets |  ;

sujet: entite predicats '.';

predicats: predicat ';' predicats |;

//suite_predicat: ';' predicats |  ; 

predicat: entite objets ;

objets: objet ',' objets | ;

//suite_objet: ',' objets |  ;

objet: entite | texte ;


entite: '<'ID'>';

texte: '"'ID+'"'; 

/** Analyseur lexicale */
ID  :   ('a'..'z'|'A'..'Z'|'0'..'9'|'-'|'&')+ ;
WS  :   (' '|'\t'|'\r'|'\n')+ {skip();} ;

