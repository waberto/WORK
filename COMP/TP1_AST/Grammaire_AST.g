grammar Grammaire_AST;

options {
	language = java;
	ASTLabelType = CommonTree ;
	output = AST;
	}


/** Analyseur syntaxique */

doc: sujets -> ^(doc sujets) ;

sujets: sujet '.' sujets -> ^(sujets sujet) | 
	;

sujet: entite predicats -> ^(sujet entite predicats)
	 ;

predicats: predicat suite_predicat -> ^(sujet predicat suite_predicat)
	 ;

suite_predicat: ';' predicats -> predicats |
	 ;

predicat: entite objets -> ^(predicat entite objets)
	 ;

objets: objet suite_objet -> ^(predicat objet suite_objet)
	 ;


suite_objet: ',' objets -> objets |
		; 


objet: 	 entite -> ^(objet entite)
	| texte -> ^(objet texte)
	;  


entite: '<'ID'>';

texte: '"'ID'"'; 


/** Analyseur lexicale */
ID  :   ('a'..'z'|'A'..'Z'|'0'..'9'|'-'|'&')+ ;
WS  :   (' '|'\t'|'\r'|'\n')+ {skip();} ;
