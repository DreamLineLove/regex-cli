# Specification

Different options available are to selected by the use of command-line arguments.

With this new specification, both the C++ and Java implementations as well as all
subsequent implementations will fulfill the same requirements.

## Options

- When *--verbose=true* or *-v* flag is used, the program should output each line 
and the number of matches corresponding to each line. When the *-v* flag is absent
or *--verbose* is set to false, the program should simply output the total number.
- When *--line=true* or *-l* flag is used, the program should treat each line as the
smallest input unit against which the pattern will be matched. Otherwise, individual 
words should be treated as separate input sequences.
- *"pattern"* is a command-line argument used to provide the program with the regular
expression pattern against which input sequences will be matched.
- *"file-path"* is a command-line argument used to provide the program with the relative
file-path of the file to be used as the input. Each line will be extracted from said file.
