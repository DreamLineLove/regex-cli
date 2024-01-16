# regex-cli
A simple command-line regular expression tool written in multiple languages.

## Contents
As of right now, the tool is written in C++ and Java.
In the future, I intend to write a version in Go.

The executable(s) are inside the *bin* directory. You can also build from source, given that you have the necessary toolchain. 

*Note:* Ensure that you have a Java runtime installed on your system to run the .class executable.

### C++
```
regex-cli
├── cpp
│   ├── bin
│   │   └── regex-cli-app
│   └── src
│       └── regex-cli.cpp
└── README.md
```

### Java
```
regex-cli
├── java
│   ├── bin
│   │   └── RegexCLI.class
│   └── src
│       └── regex-cli.java
└── README.md
```

## Usage

- First, clone the repository to your local machine:
```
$ git clone https://github.com/DreamLineLove/regex-cli.git
```
- Choose your preferred language and then simply run the program:
```
$ ./cpp/bin/regex-cli-cpp
```
or
```
$ java -cp java/bin/ RegexCLI
```
- Simply run the program without any flags, as shown above, to see the available options.
