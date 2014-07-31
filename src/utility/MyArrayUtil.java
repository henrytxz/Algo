package utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: henry
 * Date: 8/18/13
 * Time: 10:05 AM
 * To change this template use File | Settings | File Templates.
 */
public class MyArrayUtil {
    private MyArrayUtil() {}

    public static void printArray(Comparable[] array) {
        for (Comparable element : array) {
            System.out.print(element+" ");
        }
        System.out.println();
    }

    /**
     *  @Deprecated because
     *  Integer[] A = list.toArray(new Integer[list.size()]);
     *  is better
     */
    @Deprecated
    public static Integer[] ListIntegersToIntegerArray(List<Integer> list) {
        Integer[] result = new Integer[list.size()];
        for (int i=0; i<list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static boolean checkArrayIntegerSorted(Integer[] result) {
        for (int i=0;i<result.length-1;i++) {
            if (result[i]>result[i+1]) {
                System.out.println("not sorted! result["+i+"]="+result[i]+", result["+(i+1)+"]="+result[i+1]);
                return false;
            }
        }
        return true;
    }

    public static List<Integer> ListIntegerFromFile(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        List<Integer> list = new ArrayList<Integer>();
        String row = br.readLine();

        while (row != null) {
            list.add(Integer.valueOf(row));
            row = br.readLine();
        }
        br.close();
        return list;
    }

    public static List<Integer> ListIntegerFromFile(File file, int numberOfLinesToGet) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        List<Integer> list = new ArrayList<Integer>();
        String row = br.readLine();

        int count = 0;

        while (row != null) {
            if (count == numberOfLinesToGet)
                break;
            list.add(Integer.valueOf(row));
            row = br.readLine();
            count++;
        }
        br.close();
        return list;
    }


}
