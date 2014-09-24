package sedgy.graph;

import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;

import java.util.Arrays;

/**
 * Created by henry on 9/24/2014.
 */
public class DijkstraSP {
    private double[] distTo;
    private DirectedEdge[] edgeTo;

    public DijkstraSP(EdgeWeightedDigraph G, int s) {
        distTo = new double[G.V()];
        edgeTo = new DirectedEdge[G.V()];
        for (int i=0; i<distTo.length; i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;

        MinDistPQ q = new MinDistPQ(5);
        q.enqueue(s);
        int v;
        while (!q.isEmpty()) {
            v = q.delMin();
            for (DirectedEdge e : G.adj(v)) {
                if (distTo[e.to()]==Double.POSITIVE_INFINITY) {
                    q.enqueue(e.to());
                }
                relax(e);
            }
        }
    }

//    Iterable<DirectedEdge> pathTo(int v) {
//        return
//    }

    boolean hasPathTo(int v) {
        return edgeTo[v]!=null;
    }

    private void relax(DirectedEdge e) {
        int w = e.to();
        if (distTo[w] > distTo[e.from()]+e.weight()) {
            System.out.println("relax edge "+e.toString());
            if (e.from()==2 && w==4)
                System.out.println("break point");
            distTo[w] = distTo[e.from()]+e.weight();
            edgeTo[w] = e;
        }
    }

    private class MinDistPQ {
        Integer[] bh; //binary heap
        int N;    //number of items on the queue

        MinDistPQ(int capacity) {
            bh = new Integer[capacity+1];

        }
        void enqueue(int i) {
            bh[++N] = i;
            swim(N);
        }

        private void swim(int k) {
            while (k>1 && distTo[k]<distTo[k/2]) {
                exch(k, k/2);
                k=k/2;
            }
        }

        private void exch(int i, int j) {
            int tmp = bh[i];
            bh[i] = bh[j];
            bh[j] = tmp;
        }

        public boolean isEmpty() {
            return N==0;
        }

        public int delMin() {
            if (isEmpty()) throw new IndexOutOfBoundsException();
            System.out.println("about to del min, bh:"+ Arrays.toString(bh));
            int min = bh[1];
            exch(1, N);
            sink(1);
            bh[N--] = null;
            System.out.println("at the end of del min, bh:"+ Arrays.toString(bh));
            return min;
        }

        private void sink(int k) {
            int l = 2*k;
            while (l<=N) {
                if ((l+1<=N)&&(distTo[l+1] < distTo[l])) l++;
                if (distTo[k]>=distTo[l]) break;
                exch(k, l);
                k = l;
            }
        }
    }
}
