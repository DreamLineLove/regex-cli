# Specification

Different options available are to selected by the use of command-line arguments.

With this new specification, both the C++ and Java implementations as well as all
subsequent implementations will fulfill the same set of requirements.

## Options

#### -v, --verbose
When *--verbose* or *-v* flag is used, the program should output each line 
and the number of matches corresponding to that line. When the *-v* flag is absent
or *--verbose* is set to false, the program should simply output the total number.

#### -l, --line-mode
When *--line-mode* or *-l* flag is used, the program should treat a line as the
smallest input unit against which the pattern will be matched. Otherwise, individual 
words should be treated as the smallest unit.

#### pattern="pattern"
*"pattern"* is a command-line argument used to provide the program with the regular
expression pattern against which input sequences will be matched.

#### file-path="relative-file-path"
*"file-path"* is a command-line argument used to provide the program with the relative
file-path of the file to be used as the input. Each line will be extracted from said file.

## Future ideas
- Accept multiple file-paths and operate on each file on a different thread (concurrency)
- Build a web service (with or without a user interface) that will achieve the same 
functionality 
