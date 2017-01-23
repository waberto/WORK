grammar ast;

options {
	ASTLabelType = CommonTree ;
	output = AST;
	}



objet: 	 ID ->  ID
	;  
//entite: '<'ID'>';

//texte: '"'ID'"';

ID  :  '<' ('a'..'z'|'A'..'Z'|'0'..'9'|'-'|'&')+'>' | '"' ('a'..'z'|'A'..'Z'|'0'..'9'|'-'|'&')+'"' ;
WS  :   (' '|'\t'|'\r'|'\n')+ {skip();} ;
 
 