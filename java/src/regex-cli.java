import java.io.File;
import java.io.FileNotFoundException;
import java.util.regex.*;
import java.util.Scanner;

class RegexCLI {

    public static void main(String argv[]) {

        String regex = argv[0];
        String fName = argv[1];

        try {
            File f = new File(fName);
            Scanner sc = new Scanner(f);

            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                Boolean b = Pattern.matches(regex, line);
                if (b == true) {
                    System.out.println(line + " [matches]");
                } else {
                    System.out.println(line);
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
