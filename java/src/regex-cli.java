import java.io.File;
import java.io.FileNotFoundException;
import java.util.regex.*;
import java.util.Scanner;

class RegexCLI {

    public static void main(String argv[]) {

        String regex = argv[0];
        String fName = argv[1];

        Pattern p = Pattern.compile(regex);
        Scanner sSc = new Scanner(System.in);

        System.out.print("Do you want to match words or each line in the file? (y or n)...");
        Boolean matchWords = sSc.nextLine().trim() == "y" ? true : false;
        
        Boolean countTotal = false;
        if (matchWords) {
            System.out.print("Do you want to count total matches or just an inline indicator is fine? (y or n)...");
            countTotal = sSc.nextLine().trim() == "y" ? true : false;
        }

        sSc.close();

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
                        System.out.println(line + " [" + inner + "]");
                        outer += inner;
                    }
                    sc.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                System.out.println("Total =" + outer);
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
                        System.out.println(line + " [" + count + "]");

                    }
                    sc.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
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
                        System.out.println(line + " [matches]");
                        count++;
                    } else {
                        System.out.println(line);
                    }
                }
                sc.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            System.out.println("Total = " + count);
        }


    }

}
