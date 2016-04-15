grammar PropertyFile;

@members {
    void startFile() { }
    void finishFile() { }
    void defineProperty(Token name, Token value) {
        System.out.println(name.getText() + "=" + value.getText());
    }
}

file:   {startFile();} prop+ {finishFile();}
    ;

prop:   ID '=' STRING '\n' {defineProperty($ID, $STRING);}
    ;

ID  :   [a-z]+
    ;

STRING
    :   '"' .*? '"'
    ;
