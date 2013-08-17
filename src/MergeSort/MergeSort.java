package MergeSort;

/**
 * Created with IntelliJ IDEA.
 * User: henry
 * Date: 8/17/13
 * Time: 3:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class MergeSort {
    public static int[] MergeSort(int[] A, int n, int begin, int end) {
        System.out.println("MergeSort on "+begin+":"+end);
        if (begin==end)
            return new int[]{A[begin]};

        int[] B = MergeSort(A, n/2, begin+0, begin+n/2-1);  //todo: fix it when n is odd
        int[] C = MergeSort(A, n/2, begin+n/2, begin+n-1);
        int[] D = Merge(B, C);
        return D;
    }

    private static int[] Merge(int[] B, int[] C) {
        if (B==null)
            throw new IllegalArgumentException("first array argument is empty, can't merge");
        if (C==null)
            throw new IllegalArgumentException("second array argument is empty, can't merge");

        int[] D = new int[B.length+C.length];

        int i=0;
        int j=0;

        for(int k=0; k<D.length; k++)
        {
            if(i<B.length&&(j>=C.length||B[i]<=C[j])) {     //j>=C.length => if j's gone past the entirety of C, just copy B's elements
//                System.out.println("B["+i+"] is "+B[i]+", C["+j+"] is "+C[j]+", copying over B["+i+"]"); //Integer.toString(
//                System.out.println("Copying B["+i+"] to D");
                D[k]=B[i];
                i++;
            } else {                                                                                     //if(j<C.length&&(C[j]<B[i]||i==B.length-1)) {
//                System.out.println("B["+i+"] is "+B[i]+", C["+j+"] is "+C[j]+", copying over C["+j+"]");
//                System.out.println("Copying C["+j+"] to D");
                D[k]=C[j];
                j++;
            }

//            else {
//                D[k]=C[j];
//                j++;
//            }
        }

        System.out.println("D is:");
        printIntArray(D);

        return D;
    }

    public static void printIntArray(int[] array) {
        for (int element : array) {
            System.out.print(element+" ");
        }
        System.out.println();
    }
}
