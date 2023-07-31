# regex-cli
A simple command line tool to analyze strings using regular expressions and return the number of matches found.

## Contents
As of right now, the tool is written only in C++. 
I have intent to write it in Go in the future.

The executables will be inside *bin* folder in the respective language's directory. 
Source code can also be found in the respective langauge directories as well.
### C++
```
regex-cli/
    go/
      regex-cli.go
      bin/
        regex-cli-go
```
### Go
```
regex-cli/
    cpp/
      regex-cli.cpp
      bin/
        regex-cli-cpp
```

## Usage
 
- First, clone the repository to your local machine:
```
    $ git clone https://github.com/DreamLineLove/regex-cli.git
```
- Make up your mind about your preferred language and run the program:
```
    $ ./cpp/bin/regex-cli-cpp
```
or
```
    $ ./go/bin/regex-cli-go
```
- The first time you run the program, you will be greeted by helpful instructions.
