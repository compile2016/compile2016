grammar cymbol;

cymbol
    :   (functionDecl | varDecl)+
    ;

varDecl
    :   type ID ('=' expr)? ';'
    ;

type:   'float' | 'int' | 'void'
    ;

ID  :   [_a-zA-Z] [_a-zA-Z]*
    ;

// int isOdd(int x) { return (x % 2 == 1) ? true : false; }
functionDecl
    :   type ID '(' formalParameters? ')' block
    ;

formalParameters
    :   formalParamenter (',' formalParamenter)*
    ;

formalParamenter
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

expr:   ID '(' exprList? ')' //函数调用
    |   expr '[' expr ']' //数组
    |   '-' expr
    |   '!' expr
    |   expr '*' expr
    |   expr ('+' | '-') expr
    |   expr '==' expr
    |   ID
    |   INT
    |   '(' expr ')'
    ;

exprList
    :   expr (',' expr)*
    ;

INT :   [0-9]+;

WS  :   [ \t\r\n] -> skip
    ;