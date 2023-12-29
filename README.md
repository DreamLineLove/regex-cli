# regex-cli
A simple command line regular expression tool written in multiple languages.

## Contents
As of right now, the tool is written in C++ and Java.
I intend to write a version in Go in the future.

The executable(s) are inside the *bin* directory. You can also build from source.
*Note* You need to install the Java toolchain to run the .class executable.

### C++
```
regex-cli/
    cpp/
        src/
            regex-cli.cpp
        bin/
            regex-cli-cpp
```

### Java
```
regex-cli/
    java/
        src/
            regex-cli.java
        bin/
            RegexCLI.class
```

## Usage

- First, clone the repository to your local machine:
```
$ git clone https://github.com/DreamLineLove/regex-cli.git
```
- Make a decision on your preferred language and run the program:
```
$ ./cpp/bin/regex-cli-cpp
```
or
```
$ java -cp java/bin/ RegexCLI
```
- Run the program as above (without any flags) and you will be greeted with helpful instructions.
