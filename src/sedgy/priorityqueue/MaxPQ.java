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
}
