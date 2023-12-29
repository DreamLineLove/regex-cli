import java.io.File;
import java.io.FileNotFoundException;
import java.util.regex.*;
import java.util.Scanner;

class RegexCLI {

    public static void main(String argv[]) {

        if (argv.length == 2) {
            String regex = argv[0];
            String fName = argv[1];

            Pattern p = Pattern.compile(regex);
            Scanner sSc = new Scanner(System.in);

            System.out.print("\nMatch each word or each line in the file? \t\t\t(w or l): ");
            Boolean matchWords = sSc.nextLine().trim().equals("w") ? true : false;

            Boolean countTotal = false;
            if (matchWords) {
                System.out.print("Count total matches or just an inline indicator is fine? \t(c or i): ");
                countTotal = sSc.nextLine().trim().equals("c") ? true : false;
            }

            sSc.close();
            System.out.println("\n------");

            if (matchWords) {
                if (countTotal) {
                    int outer = 0;

                    try {
                        File f = new File(fName);
                        Scanner sc = new Scanner(f);

                        while (sc.hasNextLine()) {
                            int inner = 0;
                            String line = sc.nextLine().trim();
                            Matcher m = p.matcher(line);

                            while (m.find()) {
                                inner++;
                            }
                            System.out.println("[" + inner + "]\t" + line);
                            outer += inner;
                        }
                        sc.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }

                    System.out.println("------");
                    System.out.println("Total[" + outer + "]");
                } else {
                    try {
                        File f = new File(fName);
                        Scanner sc = new Scanner(f);

                        while (sc.hasNextLine()) {
                            int count = 0;
                            String line = sc.nextLine().trim();
                            Matcher m = p.matcher(line);

                            while (m.find()) {
                                count++;
                            }
                            System.out.println("[" + count + "]\t" + line);

                        }
                        sc.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    System.out.println("------");
                }
            } else {
                int count = 0;

                try {
                    File f = new File(fName);
                    Scanner sc = new Scanner(f);

                    while (sc.hasNextLine()) {
                        String line = sc.nextLine().trim();
                        Matcher m = p.matcher(line);
                        Boolean b = m.matches();

                        if (b) {
                            System.out.println("✓\t" + line);
                            count++;
                        } else {
                            System.out.println(" \t" + line);
                        }
                    }
                    sc.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                System.out.println("------");
                System.out.println("Total[" + count + "]");
            }

            System.out.println();
        } else {
            System.out.println("Regular Expressions Command Line Tool");
            System.out.println("          (written in Java)");
            System.out.println("          -----------------\n");
            
            System.out.println("The following 2 arguments are required:");
            System.out.println("\tregex\tThe regular expression to use");
            System.out.println("\tfName\tA filepath. The strings to be matched with the regex pattern will be extracted from this file.\n");

            System.out.println("For example:");
            System.out.println("\tjava -cp java/bin/ RegexCLI javaIsCool! ../samples/t1.txt");
            System.out.println("\t                            [..regex..] [.....fName.....]");
        }

    }

}
