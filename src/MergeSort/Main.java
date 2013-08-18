package MergeSort;

import UtilityClasses.MyArrayUtil;

import java.io.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: henry
 * Date: 8/17/13
 * Time: 2:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) {
        File file = new File("C:/Users/henry/Dropbox/Coursera/Coursera algo class/Programming Questions/Programming Questions week 1/IntegerArray.txt");
        try {
            List<Integer> list = MyArrayUtil.ListIntegerFromFile(file);

            int[] A = MyArrayUtil.ListIntegersTointArray(list);

            int[] result = MergeSort.MergeSort(A, A.length, 0, A.length-1);

//            MyArrayUtil.printIntArray(result);

            //when we are dealing with "Big" data :), eye-balling is not the best way to check

            MyArrayUtil.checkArrayintSorted(result);
/*
            read on Java I/O
            File output = new File("C:/Users/henry/Dropbox/Coursera/Coursera algo class/Programming Questions/Programming Questions week 1/SortedIntegerArray.txt");
            if (!output.exists())
                output.createNewFile();
            BufferedWriter bw = new BufferedWriter(new FileWriter(output));
            bw.write(result.toString());
            bw.close();
            System.out.println("Done");
*/

        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
