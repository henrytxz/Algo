package MergeSort;

import UtilityClasses.MyArrayUtil;

import java.io.*;
import java.util.ArrayList;
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
//        int[] A = new int[]{54044,
//            14108,
//            79294,
//            29649,
//            25260,
//            60660,
//            2995 ,
//            53777,
//            49689,
//            9083};



        File file = new File("C:/Users/henry/Dropbox/Coursera/Coursera algo class/Programming Questions/Programming Questions week 1/IntegerArray.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            List<Integer> list = new ArrayList<Integer>();
            String row = br.readLine();
            while (row != null) {
                list.add(Integer.valueOf(row));
                row = br.readLine();
            }
            br.close();
            int[] A = ListIntegersTointArray(list);

            int[] result = MergeSort.MergeSort(A, A.length, 0, A.length-1);

//            MyArrayUtil.printIntArray(result);

            //when we are dealing with "Big" data :), eye-balling is not the best way to check

            for (int i=0;i<result.length-1;i++) {
                if (result[i]>result[i+1])
                    System.out.println("not sorted! result["+i+"]="+result[i]+", result["+(i+1)+"]="+result[i+1]);
            }
            System.out.println("yeeaah sorted!");

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

    private static int[] ListIntegersTointArray(List<Integer> list) {
        int[] result = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
