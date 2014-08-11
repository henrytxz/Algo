package sedgy.priorityqueue;

/**
 * Created by henry on 8/9/2014.
 */
public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N;

    public MaxPQ() {}

    public MaxPQ(int capacity) {
        N = capacity;   //slides don't have this line...
        pq = (Key[]) (new Comparable[N]);
    }

    public MaxPQ(Key[] a) {
        pq = a; //expect a 1 indexed array
        N = a.length-1;
    }

    Key max() {return pq[1];}

    protected void swim(int k) {
        while (k>1) {
            int parentIndex = (int) Math.floor(k/2);
            if (a_less_than_b(parentIndex, k)) {
                exch(parentIndex, k);
                k = parentIndex;
            } else {
                break;
            }
        }
    }

    protected void sink(int k) {
        while (2*k<N) {
            int j = 2 * k;
            if (a_less_than_b(j, j + 1)) {
                j++;
            }

            if (a_less_than_b(k, j)) {
                exch(k, j);
                k = j;
            } else break;
        }
    }

    private void exch(int parentIndex, int k) {
        Key tmp = pq[parentIndex];
        pq[parentIndex] = pq[k];
        pq[k] = tmp;
    }

    protected boolean a_less_than_b(int i, int j) {
        return (pq[i].compareTo(pq[j])<0);
    }

    protected void print() {
        for (Key key : pq) {
            System.out.print(key + " ");
        }
        System.out.println();
    }

    protected Key[] getPq() {return pq;}

//    System.arraycopy(a, 0, pq, 0, a.length);

    public void insert(Key x) {
        if (N+1==pq.length) resize(2*pq.length);
        pq[++N] = x;
        swim(N);
        assert isMaxHeap();
    }

    protected void resize(int newSize) {
        Key[] tmp = (Key[]) new Comparable[newSize];
        System.arraycopy(pq, 0, tmp, 0, pq.length);
        pq = tmp;
    }

    /*
     borrowed from Sedgy
     is pq[1..N] a max heap?
    */
    private boolean isMaxHeap() {
        return isMaxHeap(1);
    }

    /*
     borrowed from Sedgy
     is subtree of pq[1..N] rooted at k a max heap?
    */
    private boolean isMaxHeap(int k) {
        if (k > N) return true;
        int left = 2*k, right = 2*k + 1;
        if (left  <= N && a_less_than_b(k, left))  return false;
        if (right <= N && a_less_than_b(k, right)) return false;
        return isMaxHeap(left) && isMaxHeap(right);
    }
}
