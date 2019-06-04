# Structured Data

## May 24

### Remarks
The csv input file has been added to the project resources, hence the updated loading of the file in the main class where it is loaded using the getResourceAsStream method.

### Homework for next time
Output in the console each line in the following format:

>Line 1:
&nbsp;&nbsp;&nbsp;&nbsp;<header1>: <value1>
&nbsp;&nbsp;&nbsp;&nbsp;<header2>: <value2>
&nbsp;&nbsp;&nbsp;&nbsp;...
&nbsp;&nbsp;&nbsp;&nbsp;<headerN>: <valueN>
Line 2:
&nbsp;&nbsp;&nbsp;&nbsp;<header1>: <value1>
&nbsp;&nbsp;&nbsp;&nbsp;...
...

Then try and output it as a json object:
[
	{"<header1>":"<value1>","<header2>":"<value2>",...,"<headerN>":"<valueN>"},
	...
	{"<header1>":"<value1>","<header2>":"<value2>",...,"<headerN>":"<valueN>"}
]