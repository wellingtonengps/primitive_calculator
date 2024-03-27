grammar Calculator;

prog: cmd*;

cmd: ID cmd NEWLINE (cmd)* #brances | lvalue ATTRIBUTION exp SEMICOLON #assing | exp SEMICOLON #print;

exp: aexp #basicsExprs;

aexp:  left=aexp op=(PLUS|MINUS) right=mexp #PlusMinus
      | mexp #moreExprs;

mexp:  left=mexp op=(MULT|DIV|MOD) right=sexp #MultDivMod
     | sexp #literalExprs;

sexp: INT #int | pexp #acessorValue;

pexp: lvalue #value;

lvalue: ID #id;

INT: [0-9]+;
SEMICOLON        : ';' ;


ATTRIBUTION      : '=' ;

PLUS                : '+' ;
MINUS               : '-' ;
MULT                : '*' ;
DIV                 : '/' ;
MOD                 : '%' ;

ID        : CHAR (CHAR | NUMBER | '_')* ;
CHAR      : LOWERCASE | UPPERCASE ;
NUMBER    : [0-9] ;
UPPERCASE : [A-Z] ;
LOWERCASE : [a-z] ;

WS                : [ \t]+ -> skip ;
NEWLINE           : ([\r\n]+ | [\n]+) -> skip ;




