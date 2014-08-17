package gayle.vimeo;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by henry on 8/8/2014.
 * Given an array of integers, find the consecutive sequence with the largest sum
 * What would you like as the output? the sum or the endpoints of the sequence?
 */
public class FindMaxSumFromArray {

    private static Result calcOnePositiveSum(int i, int[] input) {    //for test case 1, call 1, sum+=input[1]=2, sum+=input[2]=5
        int sum=0;
        while (i<input.length && input[i]>=0) {     //for test case 1, call 2, sum+=input[5]=6, sum+=input[6]=13
            sum += input[i];
            i++;
        }
        return new Result(i, sum);
    }

    private static Result calcOneNegativeSum(int i, int[] input) {
        int sum=0;
        while (i<input.length && input[i]<0) {
            sum += input[i];
            i++;
        }
        return new Result(i, sum);
    }

    public static Integer findMaxSum2(int[] a) {
        if (a==null || a.length==0) return null;
        Integer max = 0;
        int curr = 0;
        for (int i : a) {
            curr += i;
            if (curr > max) max = curr;
            if (curr < 0) curr = 0;
        }
        return max;
    }

    public static int findMaxSum(int[] input) {

        List<Integer> chunks = new ArrayList<Integer>();
        int i = 0;
        while (input[i]<0) i++;
        while (i<input.length) {
            Result result;
            if (input[i]>=0) {
                result = calcOnePositiveSum(i, input);
            } else {
                result = calcOneNegativeSum(i, input);
            }
            chunks.add(result.sum);
            i = result.i;
        }

        int max = 0;
        int j=0;
        Result result;
        while (j<input.length) {
            result = calcOnePositiveSum(j, input);
            j = result.i;
            if (result.sum > max) max = result.sum;
        }

        return max;
    }

    private static class Result {
        private int i;
        private int sum;
        private Result(int i, int sum) {
            this.i = i;
            this.sum = sum;
        }
    }

//    private static class Result {
//        private int i;
//        private int sum;
//        private Result(int i, int sum) {
//            this.i = i;
//            this.sum = sum;
//        }
//    }

    public static void main(String[] args) {

        int[] a1 = {-1,2,3,-4,-5,6,7};
        System.out.println(findMaxSum(a1));
        Assert.assertEquals(13, findMaxSum(a1));

        int[] a2 = {1,2,-3,4,5,6,-7};
        System.out.println(findMaxSum(a2));
        Assert.assertEquals(15, findMaxSum(a2));

        int[] a3 = {4,5,6,-3,1,2,-7};
        System.out.println(findMaxSum(a3));
        Assert.assertEquals(15, findMaxSum(a3));

        /*
            around 6pm on Aug 8, understood the question a bit better
            I was mistaken about the sequence should not include any -ve numbers
            it should if it allows two +ve chunks to be connected
            this is a good example, the sequence we want is 3,-2,4 => add up to 5
        */
        int[] a4 = {-1,3,-2,4,-4};
        System.out.println(findMaxSum(a4));
        Assert.assertEquals(5, findMaxSum(a4));

        int[] a5 = {1,-2,3,-4,1};
        System.out.println(findMaxSum(a5));
        Assert.assertEquals(3, findMaxSum(a5));
    }
}
