package tim.divide_and_conquer;

import utility.Pair;

import java.math.BigInteger;

/**
 * User: henry
 * Date: 8/18/13
 * Time: 11:30 AM
 */

public class ArrayInversion {
    public static Pair<Integer[],Integer> SortAndCount(Integer[] A, int n, int begin, int end) {
//        System.out.println("SortAndCount on "+begin+":"+end);
        if (begin==end)
            return new Pair<Integer[],Integer>(new Integer[]{A[begin]},0);

        int leftHalfLength  = n/2;
        int rightHalfLength = n-leftHalfLength;
        Pair<Integer[],Integer> B_x = SortAndCount(A, leftHalfLength, begin + 0, begin + leftHalfLength - 1);  //todo: fix it when n is odd
        Integer[] B = B_x.getLeft();
        int x = B_x.getRight();
        Pair<Integer[],Integer> C_y = SortAndCount(A, rightHalfLength, begin + leftHalfLength, begin + n - 1);
        Integer[] C = C_y.getLeft();
        int y = C_y.getRight();
        Pair<Integer[],Integer> D_z = MergeAndCountSplitInv(B, C);
        Integer[] D = D_z.getLeft();
        int z = D_z.getRight();
        return new Pair<Integer[], Integer>(D,x+y+z);
    }

    private static Pair<Integer[],Integer> MergeAndCountSplitInv(Integer[] B, Integer[] C) {
        if (B==null)
            throw new IllegalArgumentException("first array argument is empty, can't merge");
        if (C==null)
            throw new IllegalArgumentException("second array argument is empty, can't merge");

        Integer[] D = new Integer[B.length+C.length];

        int i=0;
        int j=0;

        int splitInversions = 0;

        for(int k=0; k<D.length; k++)
        {
            if(i<B.length&&(j>=C.length||B[i]<=C[j])) {     //j>=C.length => if j's gone past the entirety of C, just copy B's elements
                D[k]=B[i];
                i++;
            } else {                                        //if(j<C.length&&(B[i]>C[j]||i>=B.length)) {
                D[k]=C[j];
                j++;
                splitInversions = splitInversions + (B.length-i);   //change B's index i to 1-based and subtract it with B's length
            }
        }

//        System.out.println("found "+splitInversions+" split inversions");
//        System.out.println("D is:");
//        MyArrayUtil.printArray(D);

        return new Pair<Integer[], Integer>(D,splitInversions);
    }

    public static int bruteForceCount(Integer[] A)
    {
        int count=0;
        if (A==null)
            throw new IllegalArgumentException("can't bruteForceCount a null array");
        for (int i=0;i<A.length;i++) {
            for (int j=i+1; i<j&&j<A.length; j++) {
                if (A[i]>A[j])
                    count++;
            }
        }
        return count;
    }

    public static BigInteger BigInteger_bruteForceCount(Integer[] A)
    {
        BigInteger count = BigInteger.ZERO;

        if (A==null)
            throw new IllegalArgumentException("can't bruteForceCount a null array");
        for (int i=0;i<A.length;i++) {
            for (int j=i+1; i<j&&j<A.length; j++) {
                if (A[i]>A[j])
                    count = count.add(BigInteger.ONE);
            }
        }
        return count;
    }
}
