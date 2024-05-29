# regex-cli
A simple command-line regular expression tool written in multiple languages.

## Note
As of right now, the tool is written in C++ and Java.
In the future, I intend to write a version in Go.

The executable(s) for linux are inside the *bin* directory. For other Operating Systems, please build from source using the relevant toolchain(s). 

*Note:* Also ensure that you have a Java runtime installed in order to run Java's .class (bytecode) files.

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
#### Choose your preferred language and cd into the language directory:
```
$ cd cpp/
```
or
```
$ cd java/
```
#### Once you are in a language directory, you will find a README file with further instructions on how to run the program written in that language.
Finally, if you are interested in the various considerations made during development, please look into <a href="https://github.com/DreamLineLove/regex-cli/blob/main/SPECIFICATION.md">SPECIFICATION.md</a>.

**Thanks for visiting this little code repo, cheers!**
