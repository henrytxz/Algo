package utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by henry on 8/31/2014.
 * a lot of this class is borrowed from edu.princeton.cs.introcs.In
 */
public class In {

    private Scanner scanner;                                //todo

    // assume Unicode UTF-8 encoding
    private static final String charsetName = "UTF-8";      //todo

    // assume language = English, country = US for consistency with System.out.
    private static final java.util.Locale usLocale = new java.util.Locale("en", "US");

    public In(String s) throws FileNotFoundException {
        File file = new File(s);
        if (file.exists()) {
            scanner = new Scanner(file, charsetName);
            scanner.useLocale(usLocale);
        }
    }

    public int readInt() {
        return scanner.nextInt();
    }

    /**
     * Read and return the next line.
     */
    public String readLine() {
        String line;
        try                 { line = scanner.nextLine(); }
        catch (Exception e) { line = null;               }
        return line;
    }

    public boolean isEmpty() {
        return !scanner.hasNext();  //todo
    }
}
