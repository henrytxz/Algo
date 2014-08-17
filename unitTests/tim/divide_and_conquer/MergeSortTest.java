package tim.divide_and_conquer;

import junit.framework.Assert;
import utility.MyArrayUtil;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;


/**
 * User: henry
 * Date: 8/18/13
 * Time: 10:01 AM
 */

public class MergeSortTest {

    @Test
    public void testMergeSort() {
        File file = new File("resources/IntegerArray.txt");
        try {
            List<Integer> list = MyArrayUtil.ListIntegerFromFile(file);

            Integer[] A = list.toArray(new Integer[list.size()]);

            Integer[] result = MergeSort.MergeSort(A, A.length, 0, A.length-1);

            Assert.assertTrue(MyArrayUtil.checkArrayIntegerSorted(result));

        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            Assert.fail();
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void test1() {
//        Integer[] A = new Integer[]{54044,
//                            14108,
//                            79294,
//                            29649,
//                            25260,
//                            60660,
//                            2995 ,
//                            53777,
//                            49689,
//                            9083};

        Integer[] A = new Integer[]{54044,
                79294,
                29649,
                25260,
                60660,
                2995 ,
                53777,
                49689,
                9083};

        Integer[] result = MergeSort.MergeSort(A,A.length,0,A.length-1);
        MyArrayUtil.checkArrayIntegerSorted(result);
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
