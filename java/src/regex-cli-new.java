interface Option {
    int matches(Counter ctr, String line);
}

class RegexEngine {
    private Option op;

    void setOption(Option op) {
        this.op = op;
    }

    int matches(Counter ctr, String line) {
        op.matches(ctr, line);
    }
}

class RegexCLI {
    static boolean verbose = false;
    static boolean line_mode = false;
    static String pattern;
    static String file_path;

    static void parseArguments(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            boolean startsWithSingleDash = (arg.charAt(0) == '-' ? true : false) && (arg.charAt(1) == '-' ? false : true);
            
            if (startsWithSingleDash) {
                if (arg.contains("v")) verbose = true;
                if (arg.contains("l")) line_mode = true;
            } else if (arg.equals("--verbose")) {
                verbose = true;
            } else if (arg.equals("--line-mode")) {
                line_mode = true;
            } else if (arg.startsWith("--pattern=\"") && arg.endsWith("\"")) {
                String[] parts = arg.split("=");
                String quotedPart = parts[1];
                pattern = quotedPart.substring(0, quotedPart.length());
            } else {
                String[] parts = arg.split("=");
                String quotePart = parts[1];
                file_path = quotePart.substring(0, quotePart.length());
            }

            System.out.println("verbose = ", verbose);
            System.out.println("line-mode = ", line-mode);
            System.out.println("pattern = ", pattern);
            System.out.println("file-path = ", file_path);
        }
    }

    public static void main(String[] args) {
        parseArguments(args);
    }
}
