package tim.quicksort;

import java.util.Arrays;

/**
 * User: henry
 * Date: 8/24/13
 * Time: 1:33 PM
 */

public class QuickSort {
    public static int sortAndCountNumberOfSwaps(Integer[] A) {
        int pivotPosition = pickPivotStart(A, 0, A.length - 1);
        return partition(A,pivotPosition,0,A.length-1);
    }

    private static int pickPivotStart(Integer[] A, int start, int end) {
        return start;
    }

    public static int partition(Integer[] A, int pivotPosition, int start, int end) {
//        System.out.println("partition(A,"+pivotPosition+","+start+","+end+")");
        if (A.length<2 || start==end)   // A is so small that it requires no sorting, or the partition is 1 element only
            return 0;
        if (start<0)
            throw new IllegalArgumentException("in partition(...), start can't be less than 0");
        if (end>A.length)
            throw new IllegalArgumentException("in partition(...), end should not be greater than the length of the array");
        int pivot = A[pivotPosition];
        int swapCount=0;
        int i=start+1;
        for (int j=start+1;j<=end;j++) {
            if (A[j]<pivot) {
                if (A[i]>pivot) {
                    swap(A,i,j);
                    swapCount++;
                }
                i++;
            }
//            if (A[i]>pivot && A[j]<pivot) {
//                swap(A,i,j);
//                swapCount++;
//                i++;
//            }
        }

        if (pivot>A[i-1]) {
            swap(A,pivotPosition,i-1);  //for the eg 3,8,2,5,1,4,7,6    it becomes 3,2,1,5,8,4,7,6    and i=3 => i-1=2 => 0 and 1 are to the left and 3 and above to the right
            swapCount++;
        }

//        int pivotPositionL = pickPivotStart(Arrays.asList(A).subList(0,i-2).toArray(new int[i-2-(0-1)]));

        int countSwapsL = 0;
        if (start<i-2) {
            int pivotPositionL = pickPivotStart(Arrays.copyOfRange(A, start, i-2), start, i-2);    //0,1
            countSwapsL = partition(A, pivotPositionL,start,i-2);           //0,0,1
        }

        int countSwapsR = 0;
        if (i<end) {
            int pivotPositionR = pickPivotStart(Arrays.copyOfRange(A, i, end), i, end);        //3,7
            countSwapsR = partition(A, pivotPositionR,i,end);              //3,3,7
        }

        return swapCount+countSwapsL+countSwapsR;
    }

    static void swap(Integer[] A, int i, int j) {
        if (i<A.length&&j<A.length) {
            int tmp = A[i];
            A[i]=A[j];
            A[j]=tmp;
        }
    }
}
