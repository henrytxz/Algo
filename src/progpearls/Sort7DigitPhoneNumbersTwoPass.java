package progpearls;

import gayle.bitmanipulation.Bit;

import java.io.*;

/**
 * pb 5 on page 8
 */
public class Sort7DigitPhoneNumbersTwoPass {
    private static int SIZE_OF_BYTE = 8;
    private static int SIZE_OF_INT  = 32;
    private static int fiveMillion = 5000000;

    public static void main(String[] args) throws FileNotFoundException, IOException {
         /*
            init bit array
            read file, flip bits
            go thru bit array, save to file

            repeat, append to file
         */

        int[] a = new int[new Double(Math.ceil(Math.pow(10,7)/SIZE_OF_INT)).intValue()/2];  // divide by 2 => will use 5 million bits => fits into the 1MB/8 million bits constraint

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("resources/progpearls/SortPhoneNumbersInput")));
        String line;

        while ((line=br.readLine())!=null) {
            int number = Integer.parseInt(line);
            if (number<fiveMillion) {
                a[number / SIZE_OF_INT] = Bit.setBit(a[number / SIZE_OF_INT], number % SIZE_OF_INT);
            }
        }
        br.close();
        System.out.println("done reading file for the 1st time, begin writing");
        writeArrayToFile(a, 0, false);

        br = new BufferedReader(new InputStreamReader(new FileInputStream("resources/progpearls/SortPhoneNumbersInput")));
        while ((line=br.readLine())!=null) {
            int number = Integer.parseInt(line);
            if (number>=fiveMillion) {
                int cellToUse = (number-fiveMillion)/SIZE_OF_INT;
                a[cellToUse] = Bit.setBit(a[cellToUse], number % SIZE_OF_INT);
            }
        }
        br.close();
        System.out.println("done reading file for the 2nd time, begin writing");
        writeArrayToFile(a, fiveMillion, true);
    }

    private static void writeArrayToFile(int[] a, int offset, boolean append) throws IOException {
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("resources/progpearls/SortPhoneNumbersOutputTwoPass", append)));
        for (int i=0; i!=a.length; i++) {
            for (int j = 0; j != SIZE_OF_INT; j++) {
                if (Bit.getBit(a[i], j)) {
                    writer.println(i * SIZE_OF_INT + j + offset);
                }
            }
        }
        writer.close();
    }
}
