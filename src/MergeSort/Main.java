package MergeSort;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: henry
 * Date: 8/17/13
 * Time: 2:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) {

//        int[] A = new int[]{1,3,5,7,2,4,6,8};
//        int[] A = new int[]{6,2,8,4,3,7,1,5};
//        int[] A = new int[]{6,2,8,4};
//        int[] A = new int[]{6,2};

//        int[] A = new int[]{54044,
//                            14108,    3
//                            79294,
//                            29649,    5
//                            25260,    4
//                            60660,    8
//                            2995 ,    1
//                            53777,    7
//                            49689,    6
//                            9083};    2

//                    int[] A = new int[]{54044,
//                        14108,
//                        79294,
//                        29649,
//                        25260,
//                        60660,
//                        2995 ,
//                        53777};

                    int[] A = new int[]{54044,
                        14108,
                        79294,
                        29649,
                        25260,
                        60660,
                        2995 ,
                        53777,
                        49689,
                        9083};

//        File file = new File("C:\Users\henry\Dropbox\Coursera\Coursera algo class\Programming Questions\Programming Questions week 1");

        int[] result = MergeSort.MergeSort(A, A.length, 0, A.length-1);
//        MergeSort.printIntArray(result);  todo: move to the right class
    }
}
