package MergeSort;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: henry
 * Date: 8/18/13
 * Time: 10:01 AM
 * To change this template use File | Settings | File Templates.
 */
public class MergeSortTest {
        private MergeSortTest(){};

        @Test
        public static void test1() {
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

            int[] result = MergeSort.MergeSort(A,A.length,0,A.length-1);

        }


//      test cases:

//        int[] A = new int[]{1,3,5,7,2,4,6,8};
//        int[] A = new int[]{6,2,8,4,3,7,1,5};
//        int[] A = new int[]{6,2,8,4};
//        int[] A = new int[]{6,2,8};
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

}
