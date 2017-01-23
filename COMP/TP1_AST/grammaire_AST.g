grammar grammaire_AST;

options {
	ASTLabelType = CommonTree ;
	output = AST;
	}
rule 	:	 ID rul -> ^(ID rul);  
rul	:	ID; 

ID  :   ('a'..'z'|'A'..'Z'|'0'..'9'|'-'|'&')* ;
WS  :   (' '|'\t'|'\r'|'\n')+ {skip();} ;
/**
/** Analyseur syntaxique */
/**
doc: sujets ;

sujets: sujet '.' sujets 
	| 
	;
 
sujet: entite predicats -> ^(entite predicats)
	 ;

predicats: predicat suite_predicat -> ^(predicat suite_predicat)
	 ; 

suite_predicat: ';' predicats -> ^(predicats)
	 |
	 ;

predicat: entite objets -> ^(entite objets)
	 ;

objets: objet suite_objet -> ^(objet suite_objet)
	 ;


suite_objet: ',' objets -> ^(objets )
		|
		; 


objet: 	 entite 
	| texte 
	;  


entite: '<'ID'>';

texte: '"'ID+'"'; 
*/

/** Analyseur lexicale */

