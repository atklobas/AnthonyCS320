//i know it's not really json, but it looks like it
grammar json;

//every object has a list of fields, a key being the name and it's assosiated value
object :'<' keyvalue (',' keyvalue)* '>';

//arrays contain a list of objects or other arrays
array : '['(object|array) (',' object|array)* ']';

//a key, which I think has to be string or number, and its value
keyvalue: (STRING|NUMBER) '->' value;

//what types of things can be values
value:(STRING|NUMBER|object|array);

//actual values patterns
NUMBER : [0-9]+'.'?[0-9];
STRING : '"'.*?'"';
//ignore whitespaces
WS : [ \t\r\n]+ ->skip;
