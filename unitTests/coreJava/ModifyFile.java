package coreJava;

import java.io.*;

/**
 * Created by henry on 9/24/2014.
 */
public class ModifyFile {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("resources/modifiedFile")));
        out.println("hello :D");
        out.close();
    }
}
