package DivideAndConquer;

import org.junit.Before;
import org.junit.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import UtilityClasses.MyArrayUtil;


/**
 * Created with IntelliJ IDEA.
 * User: henry
 * Date: 8/18/13
 * Time: 10:01 AM
 * To change this template use File | Settings | File Templates.
 */
public class MergeSortTest {
//
//    @Before
//    public void setUp() throws Exception {
//
//    }

    @Test
    public void testMergeSort() {
        File file = new File("C:/Users/henry/Dropbox/Coursera/Coursera algo class/Programming Questions/Programming Questions week 1/IntegerArray.txt");
        try {
            List<Integer> list = MyArrayUtil.ListIntegerFromFile(file);

            int[] A = MyArrayUtil.ListIntegersTointArray(list);

            int[] result = MergeSort.MergeSort(A, A.length, 0, A.length-1);

            MyArrayUtil.checkArrayintSorted(result);

        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1() {
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
        MyArrayUtil.checkArrayintSorted(result);
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
