package progpearls;

import gayle.bitmanipulation.Bit;

import java.io.*;

/**
 * Created by henry on 10/25/2014.
 */
public class Sort7DigitNumbers {

    private static int SIZE_OF_BYTE = 8;
    private static int SIZE_OF_INT  = 32;

    public static void main(String[] args) throws FileNotFoundException, IOException {
        /*
                init bit array
                read file, flip bits
                go thru bit array, save to new file
         */

//        byte[] a = new byte[new Double(Math.ceil(Math.pow(10,7)/8)).intValue()];

        int[] a = new int[new Double(Math.ceil(Math.pow(10,7)/SIZE_OF_INT)).intValue()];

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("resources/progpearls/SortPhoneNumbersInput")));
        String line;
        while ((line=br.readLine())!=null) {
            int number = Integer.parseInt(line);
            a[number/SIZE_OF_INT] = Bit.setBit(a[number/SIZE_OF_INT], number % SIZE_OF_INT);
//            System.out.println(a[number/SIZE_OF_INT]);
        }

        System.out.println("done reading file, begin writing");

        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("resources/progpearls/SortPhoneNumbersOutput")));
        for (int i=0; i!=a.length; i++) {
            for (int j = 0; j != SIZE_OF_INT; j++) {
                if (Bit.getBit(a[i], j)) {
                    writer.println(i * SIZE_OF_INT + j);
                }
            }
        }
        writer.close();
    }
}
