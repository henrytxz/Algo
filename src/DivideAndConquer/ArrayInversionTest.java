package DivideAndConquer;

import UtilityClasses.MyArrayUtil;
import UtilityClasses.Pair;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: henry
 * Date: 8/18/13
 * Time: 11:36 AM
 * To change this template use File | Settings | File Templates.
 */
public class ArrayInversionTest {
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void debugSortAndCount() throws Exception {
        File file = new File("C:/Users/henry/Dropbox/Coursera/Coursera algo class/Programming Questions/Programming Questions week 1/IntegerArray.txt");
        try {
//            System.out.println(Integer.MAX_VALUE);
            List<Integer> list = MyArrayUtil.ListIntegerFromFile(file,94650);      //94680
            System.out.println("list size:"+list.size());

            int[] A = MyArrayUtil.ListIntegersTointArray(list);

            Pair<int[],Integer> D_total = ArrayInversion.SortAndCount(A, A.length, 0, A.length-1);

            int[] D = D_total.getLeft();

            MyArrayUtil.checkArrayintSorted(D);
            System.out.println("expect "+D_total.getRight()+" inversions");
            int expectedInversions = ArrayInversion.bruteForceCount(A);
//            System.out.println("expect "+expectedInversions+" inversions");
            Assert.assertEquals(expectedInversions, (int) D_total.getRight());

        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSortAndCount() throws Exception {
        File file = new File("C:/Users/henry/Dropbox/Coursera/Coursera algo class/Programming Questions/Programming Questions week 1/IntegerArray.txt");
        try {
            List<Integer> list = MyArrayUtil.ListIntegerFromFile(file,93000);

            int[] A = MyArrayUtil.ListIntegersTointArray(list);

            Pair<int[],Integer> D_total = ArrayInversion.SortAndCount(A, A.length, 0, A.length-1);

            int[] D = D_total.getLeft();

            MyArrayUtil.checkArrayintSorted(D);

            int expectedInversions = ArrayInversion.bruteForceCount(A);
            System.out.println("expect "+expectedInversions+" inversions");
            Assert.assertEquals(expectedInversions, (int) D_total.getRight());

        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSmallExample() throws Exception {
//        int[] A = new int[]{5,2};

        int[] A = new int[]{1,3,5,2,4,6};

        Pair<int[], Integer> D_and_total = ArrayInversion.SortAndCount(A, A.length, 0, A.length - 1);
        MyArrayUtil.checkArrayintSorted(D_and_total.getLeft());
    }

    @Test
    public void test_bruteForceCount() throws Exception {
        System.out.println(Integer.MAX_VALUE);

        int[] A = new int[]{1,3,5,2,4,6};

        int i=0;
        int j=1;
        int l=6;
    //        System.out.println(i<j&&j<l);

        Assert.assertEquals(3, ArrayInversion.bruteForceCount(A));
    }

    @Test
    public void test_BigInteger_bruteForceCount() throws Exception {
        int[] A = new int[]{1,3,5,2,4,6};

        int i=0;
        int j=1;
        int l=6;

        System.out.println(ArrayInversion.BigInteger_bruteForceCount(A).intValue());

        Assert.assertEquals(3, ArrayInversion.BigInteger_bruteForceCount(A).intValue());
    }

    @Test
    public void testBigIntegerSortAndCount() throws Exception {
        File file = new File("C:/Users/henry/Dropbox/Coursera/Coursera algo class/Programming Questions/Programming Questions week 1/IntegerArray.txt");
        try {
            List<Integer> list = MyArrayUtil.ListIntegerFromFile(file);

            int[] A = MyArrayUtil.ListIntegersTointArray(list);

            Pair<int[],Integer> D_total = ArrayInversion.SortAndCount(A, A.length, 0, A.length-1);

            int[] D = D_total.getLeft();

            MyArrayUtil.checkArrayintSorted(D);

            BigInteger expectedInversions = ArrayInversion.BigInteger_bruteForceCount(A);
            System.out.println("expect "+expectedInversions+" inversions");
//            Assert.assertEquals(expectedInversions, (int) D_total.getRight());

        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
