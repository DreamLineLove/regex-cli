import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class Counter {
    static private int count = 0;

    static int getCount() {
        return count;
    }

    static void increment() {
        count++;
    }
}

interface Option {
    void matches(String line, Pattern p);
}

class RegexEngine {
    private static Option op;

    static void setOption(Option option) {
        op = option;
    }

    static void matches(String line, Pattern p) {
        op.matches(line, p);
    }
}

class Default implements Option {
    public void matches(String line, Pattern p) {
        Matcher m = p.matcher(line);
        if (m.matches()) Counter.increment();
    }
}

class LineMode implements Option {
    public void matches(String line, Pattern p) {
        Matcher m = p.matcher(line);
        while (m.find()) Counter.increment();
    }
}

class Verbose implements Option {
    public void matches(String line, Pattern p) {
        Matcher m = p.matcher(line);
        int inner = 0;
        if (m.matches()) {
            inner = 1;
            Counter.increment();
        }
        System.out.println("[" + inner + "]\t" + line + "\n");
    }
}

class VerboseLineMode implements Option {
    public void matches(String line, Pattern p) {
        Matcher m = p.matcher(line);
        int inner = 0;
        while (m.find()) {
            inner += 1;
            Counter.increment();
        }
        System.out.println("[" + inner + "]\t" + line + "\n");
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
            } else if (arg.startsWith("--pattern=")) {
                String[] parts = arg.split("=");
                String quotedPart = parts[1];
                pattern = quotedPart.substring(0, quotedPart.length());
            } else if (arg.startsWith("--file-path")) {
                String[] parts = arg.split("=");
                String quotePart = parts[1];
                file_path = quotePart.substring(0, quotePart.length());
            }
        }
        // FOR DEBUGGING
        // System.out.println("verbose = " + verbose);
        // System.out.println("line-mode = " + line_mode);
        // System.out.println("pattern = " + pattern);
        // System.out.println("file-path = " + file_path);
    }

    public static void main(String[] args) {
        parseArguments(args);

        Pattern p = Pattern.compile(pattern);
        File f = new File(file_path);

        try {
            Scanner sc = new Scanner(f);

            if (verbose && line_mode) RegexEngine.setOption(new VerboseLineMode());
            else if (verbose) RegexEngine.setOption(new Verbose());
            else if (line_mode) RegexEngine.setOption(new LineMode());
            else RegexEngine.setOption(new Default());

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                RegexEngine.matches(line, p);
            }

            sc.close();
        } catch (FileNotFoundException e) {
            // FOR DEBUGGING
            // e.printStackTrace();
            System.out.println("File not found!");
            System.exit(1);
        }

        System.out.println("\tNumber of matches: " + Counter.getCount());
    }
}
