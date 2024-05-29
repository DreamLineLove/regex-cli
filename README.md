# regex-cli
A simple command-line regular expression tool written in multiple languages.

## Note
As of right now, the tool is written in C++ and Java.
In the future, I intend to write a version in Go.

- The executable (C++) for linux is inside the *bin* directory. For other Operating Systems, please build from source using the relevant toolchain(s).  
- Ensure that you have a Java runtime installed in order to run Java bytecode.

### Contents
```
regex-cli/
├── cpp
│   ├── bin
│   ├── src
│   └── README.md
├── java
│   ├── bin
│   ├── legacy
│   ├── src
│   └── README.md
├── SPECIFICATION.md
└── README.md
```

## Usage

#### First, clone the repository onto your local machine:
```
$ git clone https://github.com/DreamLineLove/regex-cli.git
```
#### Example runs of the java version
```
// From project root
$ java -cp java/bin/ RegexCLI --file-path="java/sample.txt" --pattern="foo" 
$ java -cp java/bin/ RegexCLI --file-path="java/sample.txt" --pattern="bar" 
$ java -cp java/bin/ RegexCLI --file-path="java/sample.txt" --pattern="foo" -v
$ java -cp java/bin/ RegexCLI --file-path="java/sample.txt" --pattern="bar" -v
$ java -cp java/bin/ RegexCLI --file-path="java/sample.txt" --pattern="foo" -l
$ java -cp java/bin/ RegexCLI --file-path="java/sample.txt" --pattern="bar" -l
$ java -cp java/bin/ RegexCLI --file-path="java/sample.txt" --pattern="foo" -vl
$ java -cp java/bin/ RegexCLI --file-path="java/sample.txt" --pattern="bar" -vl
```
**Please be sure to mind the "relative" path of the file and where you are running the commands!**

## End Notes

If you are curious about the various considerations made during the development of the Java version, please look into <a href="https://github.com/DreamLineLove/regex-cli/blob/main/SPECIFICATION.md">SPECIFICATION.md</a>.

Thanks for visiting my little code repository!
