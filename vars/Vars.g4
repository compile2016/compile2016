grammar Vars;

file:   (functionDecl | varDecl)+
	;

varDecl
	:   type ID ('=' expr)? ';'
	;

type:   'int'
	|   'void'
	|   'float'
	;

functionDecl
	:   type ID '(' formalParameters? ')' block
	;

formalParameters
	:   formalParameter (',' formalParameter)*
	;

formalParameter
	:   type ID
	;

block
	:   '{' stat* '}'
	;

stat:   block
	|   varDecl
	|   'if' expr 'then' stat ('else' stat)?
	|   'return' expr? ';'
	|   expr '=' expr ';'
	|   expr ';'
	;

expr:   ID '(' exprList? ')'    # Call
	|   expr '[' expr ']'       # Index
	|   '-' expr                # Negate
	|   '!' expr                # Not
	|   expr '*' expr           # Mult
	|   expr ('+' | '-') expr   # AddSub
	|   expr '==' expr          # Equal
	|   ID                      # Var
	|   INT                     # Int
	|   '(' expr ')'            # Parens
	;

exprList
	:   expr (',' expr)*
	;

K_FLOAT
	:   'float'
	;

K_INT
	:   'int'
	;

K_VOID
	:   'void'
	;

ID  :   LETTER (LETTER | [0-9])*
	;

fragment LETTER
	:   [a-zA-Z]
	;

INT :   [0-9]+
	;

WS  :   [ \t\r\n]+ -> skip
	;

SL_COMMENT
	:   '//' .*? '\r'? '\n' -> skip
	;

ML_COMMENT
	:   '/*' .*? '*/' -> skip
	;
