grammar Simple;

prog:   classDef+ ; // 类定义

classDef
    :   'class' ID '{' member+ '}' // 一个类含多个成员(函数or变量)
        {System.out.println("class "+$ID.text);}
    ;

member
    :   'int' ID ';'                       // 成员变量
        {System.out.println("var "+$ID.text);}
    |   'int' f=ID '(' ID ')' '{' stat '}' // 成员函数
        {System.out.println("method: "+$f.text);}
    ;

stat:   expr ';'
        {System.out.println("found expr: "+$expr.text+";");}
    |   ID '=' expr ';'
        {System.out.println("found assign: "+$ID.text+"="+$expr.text+";");}
    ;

expr:   INT 
    |   ID '(' INT ')'
    ;

INT :   [0-9]+ ;
ID  :   [a-zA-Z]+ ;
WS  :   [ \t\r\n]+ -> skip ;