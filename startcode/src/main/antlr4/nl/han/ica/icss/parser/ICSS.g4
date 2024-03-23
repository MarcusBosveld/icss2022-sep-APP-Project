grammar ICSS;

//--- LEXER: ---

// IF support:
IF: 'if';
ELSE: 'else';
BOX_BRACKET_OPEN: '[';
BOX_BRACKET_CLOSE: ']';


//Literals
TRUE: 'TRUE';
FALSE: 'FALSE';
PIXELSIZE: [0-9]+ 'px';
PERCENTAGE: [0-9]+ '%';
SCALAR: [0-9]+;


//Color value takes precedence over id idents
COLOR: '#' [0-9a-f] [0-9a-f] [0-9a-f] [0-9a-f] [0-9a-f] [0-9a-f];

//Specific identifiers for id's and css classes
ID_IDENT: '#' [a-z0-9\-]+;
CLASS_IDENT: '.' [a-z0-9\-]+;

//General identifiers
LOWER_IDENT: [a-z] [a-z0-9\-]*;
CAPITAL_IDENT: [A-Z] [A-Za-z0-9_]*;

//All whitespace is skipped
WS: [ \t\r\n]+ -> skip;

//
OPEN_BRACE: '{';
CLOSE_BRACE: '}';
SEMICOLON: ';';
COLON: ':';
PLUS: '+';
MIN: '-';
MUL: '*';
ASSIGNMENT_OPERATOR: ':=';




//--- PARSER: ---

stylesheet: (variableAssignment | styleRule)+ | EOF;



pixelLiteral: PIXELSIZE;
colorLiteral: COLOR;
percentageLiteral: PERCENTAGE;
scalarLiteral: SCALAR;
boolLiteral: TRUE | FALSE;

literal: colorLiteral | percentageLiteral | scalarLiteral | boolLiteral | pixelLiteral;

declaration: propertyName COLON (literal | variableReference | operation) SEMICOLON;


//Variables
variableReference: CAPITAL_IDENT;

variableAssignment: variableReference ASSIGNMENT_OPERATOR literal SEMICOLON;

//Operations
multiplyOperation: MUL;
addOperation: PLUS;
subtractOperation: MIN;

operation: operation (multiplyOperation) operation | operation (addOperation|subtractOperation) operation | (literal | variableReference) | '('operation')';

//CSS Rules
classSelector: CLASS_IDENT;
propertyName: LOWER_IDENT;
idSelector: ID_IDENT;
tagSelector: LOWER_IDENT;

selector: tagSelector | idSelector | classSelector;
styleRule: selector OPEN_BRACE (declaration| ifClause)+ CLOSE_BRACE;


//if statements
ifClause: IF BOX_BRACKET_OPEN (boolLiteral | variableReference) BOX_BRACKET_CLOSE OPEN_BRACE (declaration | ifClause)+ CLOSE_BRACE elseClause?;
elseClause: ELSE OPEN_BRACE (declaration | ifClause)+ CLOSE_BRACE;