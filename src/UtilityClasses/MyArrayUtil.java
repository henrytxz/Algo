package UtilityClasses;

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
}
