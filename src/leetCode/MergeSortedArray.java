package leetCode;

/**
 * Created by henry on 7/4/2014.
 */
public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
        int[] C = new int[A.length];
        int i=0;
        int j=0;
        int k=0;

        while (i<m || j<n) {

            if (i==m) {
                C[k]=B[j];
                j++;
            } else if (j==n) {
                C[k]=A[i];
                i++;
            } else if (A[i]>B[j]) {
                C[k]=B[j];
                j++;
            } else {
                C[k]=A[i];
                i++;
            }

            k++;
        }

        for (int l=0; l<C.length; l++) {
            A[l] = C[l];
        }
    }
}
