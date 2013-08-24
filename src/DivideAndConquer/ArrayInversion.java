package DivideAndConquer;

import UtilityClasses.Pair;

import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: henry
 * Date: 8/18/13
 * Time: 11:30 AM
 * To change this template use File | Settings | File Templates.
 */
public class ArrayInversion {
    public static Pair<int[],Integer> SortAndCount(int[] A, int n, int begin, int end) {
//        System.out.println("SortAndCount on "+begin+":"+end);
        if (begin==end)
            return new Pair<int[],Integer>(new int[]{A[begin]},0);

        int leftHalfLength  = n/2;
        int rightHalfLength = n-leftHalfLength;
        Pair<int[],Integer> B_x = SortAndCount(A, leftHalfLength, begin + 0, begin + leftHalfLength - 1);  //todo: fix it when n is odd
        int[] B = B_x.getLeft();
        int x = B_x.getRight();
        Pair<int[],Integer> C_y = SortAndCount(A, rightHalfLength, begin + leftHalfLength, begin + n - 1);
        int[] C = C_y.getLeft();
        int y = C_y.getRight();
        Pair<int[],Integer> D_z = MergeAndCountSplitInv(B, C);
        int[] D = D_z.getLeft();
        int z = D_z.getRight();
        return new Pair<int[], Integer>(D,x+y+z);
    }

    private static Pair<int[],Integer> MergeAndCountSplitInv(int[] B, int[] C) {
        if (B==null)
            throw new IllegalArgumentException("first array argument is empty, can't merge");
        if (C==null)
            throw new IllegalArgumentException("second array argument is empty, can't merge");

        int[] D = new int[B.length+C.length];

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
//        MyArrayUtil.printIntArray(D);

        return new Pair<int[], Integer>(D,splitInversions);
    }

    public static int bruteForceCount(int[] A)
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

    public static BigInteger BigInteger_bruteForceCount(int[] A)
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
