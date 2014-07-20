package tim.divide_and_conquer;

/**
 * User: henry
 * Date: 8/17/13
 * Time: 3:03 PM
 */

public class MergeSort {
    public static Integer[] MergeSort(Integer[] A, int n, int begin, int end) {
//        System.out.println("MergeSort on "+begin+":"+end);
        if (begin==end)
            return new Integer[]{A[begin]};

        int leftHalfLength  = n/2;
        int rightHalfLength = n-leftHalfLength;
        Integer[] B = MergeSort(A, leftHalfLength,  begin+0,              begin+leftHalfLength-1);  //todo: fix it when n is odd
        Integer[] C = MergeSort(A, rightHalfLength, begin+leftHalfLength, begin+n-1);
        Integer[] D = Merge(B, C);
        return D;
    }

    private static Integer[] Merge(Integer[] B, Integer[] C) {
        if (B==null)
            throw new IllegalArgumentException("first array argument is empty, can't merge");
        if (C==null)
            throw new IllegalArgumentException("second array argument is empty, can't merge");

        Integer[] D = new Integer[B.length+C.length];

        int i=0;
        int j=0;

        for(int k=0; k<D.length; k++)
        {
            if(i<B.length&&(j>=C.length||B[i]<=C[j])) {     //j>=C.length => if j's gone past the entirety of C, just copy B's elements
                D[k]=B[i];
                i++;
            } else {                                        //if(j<C.length&&(C[j]<B[i]||i==B.length-1)) {
                D[k]=C[j];
                j++;
            }
        }

//        System.out.println("D is:");
//        MyArrayUtil.printArray(D);

        return D;
    }
}
