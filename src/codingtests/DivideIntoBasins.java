package codingtests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by henry on 8/26/2014.
 * http://codingfan.wordpress.com/2012/11/04/palantir-challenge/
 */
public class DivideIntoBasins {

    private int dimension;
    private int[][] m;
    private boolean mIsSet;
    private UF uf;

    public DivideIntoBasins(int dimension) {
        this.dimension = dimension;
        m = new int[dimension][dimension];
        mIsSet = false;
        uf = new UF(dimension);
    }

    public DivideIntoBasins(int dimension, int[][] m) {
        this.dimension = dimension;
        this.m = m;
        mIsSet = true;
        uf = new UF(dimension);
    }

    public List<Integer> countBasins(BufferedReader br) throws IOException
    {
        String line;
        int row = 0;

        if (!mIsSet) {
            while ((line = br.readLine()) != null) {
                String[] a = line.split(" ");
                for (int j = 0; j < dimension; j++) {
                    m[row][j] = Integer.parseInt(a[j]);
                }
                row++;
            }
        }

        for (int i=0; i<dimension; i++) {
            for (int j=0; j<dimension; j++) {
                int lowestNeighbor = findLowestNeighbor(i, j);
                if (lowestNeighbor!=-1) {   //-1 means no lower neighbor
                    uf.union(uf.getIndexFromIJ(i,j), lowestNeighbor);
                }
            }
        }

        //if (br!=null&&br.isOpen?)   todo
        br.close();

        return uf.getCCSizes();
    }


    private int findLowestNeighbor(int i, int j) {
        int lo = -1;
        int elevation = m[i][j];
        if (i>0 && m[i-1][j]<elevation) {               //up
            elevation = m[i-1][j];
            lo = uf.getIndexFromIJ(i-1,j);
        }
        if (i<dimension-1 && m[i+1][j]<elevation) {     //down
            elevation = m[i+1][j];
            lo = uf.getIndexFromIJ(i+1,j);
        }
        if (j>0 && m[i][j-1]<elevation) {               //left
            elevation = m[i][j-1];
            lo = uf.getIndexFromIJ(i,j-1);
        }
        if (j<dimension-1 && m[i][j+1]<elevation) {     //right
            //could update elevation but not needed
            lo = uf.getIndexFromIJ(i,j+1);
        }
        return lo;
    }

    public static void main(String[] args) throws IOException {

        System.out.println("Welcome, brave warrior, what's the dimension?");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        int dimension;

        s = br.readLine();
        if (s!=null) {
            dimension = Integer.parseInt(s);
        } else {
            throw new IllegalArgumentException("expect dimension right off the bat");
        }

        int row = 0;
        int[][] m = new int[dimension][dimension];

        System.out.println("What's the next row?");
        while ((s=br.readLine())!=null && s.length()!=0) {
            String[] a = s.split(" ");
            for (int j = 0; j < dimension; j++) {
                m[row][j] = Integer.parseInt(a[j]);
            }
            row++;
        }

        DivideIntoBasins solution = new DivideIntoBasins(dimension, m);
        List<Integer> result = solution.countBasins(br);
        for (int size : result) {
            System.out.print(size + " ");
        }
    }

    // weighted union-find + path compression (learned but not copied from Robert Sedgewick algo class)
    private class UF {
        private int dimension;
        private int[] parent;	// parent will be of length dim squared, and parent[i] contains the parent of i in a tree, if parent[i]==i, i is a root
        private int[] sz; 		// size of the tree rooted at index i
        private int countCC;

        private UF(int dim) {
            dimension = dim;
            parent = new int[dim*dim];
            sz = new int[dim*dim];
            countCC = dim*dim;

            for (int i=0; i<parent.length; i++) {
                parent[i] = i;
                sz[i] = 1;
            }
        }

        private int getIndexFromIJ(int i, int j) {
            return (i*dimension+j); //for the 3x3 example, (0,0) returns 0, (0,1) 1, (2,2) 8
        }

        private void union(int p, int q) {
            int proot = root(p);
            int qroot = root(q);
            if (sz[proot]<=sz[qroot]) {
                parent[proot] = qroot;
                sz[qroot] += sz[proot];
                sz[proot] = 0;              //Robert Sedgewick doesn't do this but you could... once the line above runs, proot is no longer a root so you can argue the # of elements with p as root is 0
            } else {
                parent[qroot] = proot;
                sz[proot] += sz[qroot];
                sz[qroot] = 0;
            }
            countCC--;
        }

        private int getCountCC() {return countCC;}

        private List<Integer> getCCSizes() {
            List<Integer> s = new LinkedList<Integer>();

            for (int size : sz) {
                if(size>0) s.add(size);
            }

            /*
                do the above or this
                for (int i=0; i<parent.length; i++) {
                    if (parent[i]==i) {
                        s.add(sz[i]);
                    }
                }
            */
            return s;
        }

        private int root(int i) {
            while (parent[i]!=i) {
                parent[i] = parent[parent[i]];
                i = parent[i];
            }
            return i;
        }
    }
}
