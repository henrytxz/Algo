package UtilityClasses;

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

    public static void printIntArray(int[] array) {
        for (int element : array) {
            System.out.print(element+" ");
        }
        System.out.println();
    }

    public static int[] ListIntegersTointArray(List<Integer> list) {
        int[] result = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static boolean checkArrayintSorted(int[] result) {
        for (int i=0;i<result.length-1;i++) {
            if (result[i]>result[i+1]) {
                System.out.println("not sorted! result["+i+"]="+result[i]+", result["+(i+1)+"]="+result[i+1]);
                return false;
            }
        }
        System.out.println("yeeaah sorted!");
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
}
