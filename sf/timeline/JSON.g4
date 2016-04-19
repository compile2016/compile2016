grammar JSON;

json:   object
    |   array
    ;

//对象
object
    :   '{' (pair (',' pair)*)? '}'
    ;

pair:   key ':' value
    ;

//数组
array
    :   '[' value (',' value)* ']'
    |   '[' ']'
    ;

key :   STRING
    ;

//值
value
    :   STRING
    |   NUMBER
    |   object
    |   array
    |   'true'
    |   'false'
    |   'null'
    ;

// 字符串
STRING
    :   '"' (ESCAPE | ~('"' | '\\'))* '"'
    ;

fragment
ESCAPE
    :   '\\' ( '"' | [\\/bfnrt] | UNICODE)
    ;

fragment
UNICODE
    :   'u' HEX HEX HEX HEX
    ;

fragment
HEX
    :   [a-fA-F0-9]
    ;

//数值
NUMBER
    :   '-'? INT '.' INT EXP?
    |   '-'? INT EXP
    |   '-'? INT
    ;

fragment
INT :   [0-9] | ([1-9] [0-9]*)
    ;

fragment EXP
    :   [eE] [+\-]? INT
    ;

//空白符
WS  :   [ \t\r\n]+ -> skip
    ;
