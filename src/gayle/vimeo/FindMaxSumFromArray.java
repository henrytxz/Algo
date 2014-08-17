package gayle.vimeo;

import org.junit.Assert;

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

    public static Integer findMaxSum(int[] a) {
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
        Assert.assertEquals(13, findMaxSum(a1).intValue());

        int[] a2 = {1,2,-3,4,5,6,-7};
        System.out.println(findMaxSum(a2));
        Assert.assertEquals(15, findMaxSum(a2).intValue());

        int[] a3 = {4,5,6,-3,1,2,-7};
        System.out.println(findMaxSum(a3));
        Assert.assertEquals(15, findMaxSum(a3).intValue());

        /*
            around 6pm on Aug 8, understood the question a bit better
            I was mistaken about the sequence should not include any -ve numbers
            it should if it allows two +ve chunks to be connected
            this is a good example, the sequence we want is 3,-2,4 => add up to 5
        */
        int[] a4 = {-1,3,-2,4,-4};
        System.out.println(findMaxSum(a4));
        Assert.assertEquals(5, findMaxSum(a4).intValue());

        int[] a5 = {1,-2,3,-4,1};
        System.out.println(findMaxSum(a5));
        Assert.assertEquals(3, findMaxSum(a5).intValue());
    }
}
