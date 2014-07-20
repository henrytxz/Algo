package not_quick;

import junit.framework.Assert;
import org.junit.Ignore;
import org.junit.Test;
import tim.divide_and_conquer.ArrayInversion;
import utility.MyArrayUtil;
import utility.Pair;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

/**
 * Created by henry on 7/20/2014.
 */

public class ArrayInversionTest {

    @Ignore //coz it's not quick todo: to review
    @Test
    public void debugSortAndCount() throws Exception {
        File file = new File("resources/IntegerArray.txt");
        try {
//            System.out.println(Integer.MAX_VALUE);
            List<Integer> list = MyArrayUtil.ListIntegerFromFile(file,94650);      //94680
            System.out.println("list size:"+list.size());

            Integer[] A = MyArrayUtil.ListIntegersToIntegerArray(list);

            Pair<Integer[],Integer> D_total = ArrayInversion.SortAndCount(A, A.length, 0, A.length-1);

            Integer[] D = D_total.getLeft();

            MyArrayUtil.checkArrayIntegerSorted(D);
            System.out.println("expect "+D_total.getRight()+" inversions");
            int expectedInversions = ArrayInversion.bruteForceCount(A);
//            System.out.println("expect "+expectedInversions+" inversions");
            Assert.assertEquals(expectedInversions, (int) D_total.getRight());

        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            Assert.fail();
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Ignore //coz it's not quick todo: to review
    @Test
    public void testSortAndCount() throws Exception {
        File file = new File("resources/IntegerArray.txt");
        try {
            List<Integer> list = MyArrayUtil.ListIntegerFromFile(file, 93000);  //todo: understand what's going on here

            Integer[] A = MyArrayUtil.ListIntegersToIntegerArray(list);

            Pair<Integer[],Integer> D_total = ArrayInversion.SortAndCount(A, A.length, 0, A.length - 1);

            Integer[] D = D_total.getLeft();

            MyArrayUtil.checkArrayIntegerSorted(D);

            int expectedInversions = ArrayInversion.bruteForceCount(A);
            System.out.println("-------------------------------------------");
            System.out.println("ArrayInversionTest.testSortAndCount() expect "+expectedInversions+" inversions");
            System.out.println("-------------------------------------------");
            Assert.assertEquals(expectedInversions, (int) D_total.getRight());

        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            Assert.fail();
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Ignore //coz it's not quick todo: to review
    @Test
    public void testBigIntegerSortAndCount() throws Exception {
        File file = new File("resources/IntegerArray.txt");
        try {
            List<Integer> list = MyArrayUtil.ListIntegerFromFile(file);

            Integer[] A = MyArrayUtil.ListIntegersToIntegerArray(list);

            Pair<Integer[],Integer> D_total = ArrayInversion.SortAndCount(A, A.length, 0, A.length-1);

            Integer[] D = D_total.getLeft();

            MyArrayUtil.checkArrayIntegerSorted(D);

            BigInteger expectedInversions = ArrayInversion.BigInteger_bruteForceCount(A);
            System.out.println("expect "+expectedInversions+" inversions");
//            Assert.assertEquals(expectedInversions, (int) D_total.getRight());

        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            Assert.fail();
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}
