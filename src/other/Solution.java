package other;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by henry on 8/26/2014.
 */
public class Solution {

    private int dimension;
    private int[][] m;
    private UF uf;

    public Solution(int dimension) {
        this.dimension = dimension;
        m = new int[dimension][dimension];
        uf = new UF(dimension);
    }
    public List<Integer> countBasins(BufferedReader br) throws IOException
    {
          String line;
//        int dimension;
//        String line = br.readLine();
//        if (line!=null) {
//            dimension = Integer.parseInt(line);
//
//            int[][] basins = new int[dimension][dimension];
            int row = 0;
//            List<List<Cell>> result = new ArrayList<List<Cell>>();

//            Queue<Cell> markedCells = new ArrayDeque<Cell>();

            while ((line = br.readLine()) != null) {
                String[] a = line.split(" ");
                for (int j=0; j<dimension; j++) {
                    m[row][j] = Integer.parseInt(a[j]);
                }
                row++;
            }

            for (int i=0; i<dimension; i++) {
                for (int j=0; j<dimension; j++) {
                    int lowestNeighbor = findLowestNeighbor(i, j);
                    if (lowestNeighbor!=-1) {   //-1 means no lower neighbor
//                        System.out.println("union "+uf.getIndexFromIJ(i,j)+" and "+lowestNeighbor);
                        uf.union(uf.getIndexFromIJ(i,j), lowestNeighbor);
                    }
                }
            }

        //        if (br!=null&&br.isOpen?)   todo
        br.close();

//        return uf.getCountCC();
        return  uf.getCCSizes();

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
//            elevation = m[][] don't need anymore
            lo = uf.getIndexFromIJ(i,j+1);
        }
        return lo;
    }

    public static void main(String[] args) throws IOException {
        if (args.length==0) throw new IllegalArgumentException("no file was provided");
        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        int dimension;
        String line = br.readLine();
        if (line!=null) {
            dimension = Integer.parseInt(line);
        } else {
            throw new IllegalArgumentException("no dimension found in file:"+args[0]);
        }

        Solution s = new Solution(dimension);
        System.out.println(s.countBasins(br));
    }

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
            return (i*dimension+j); //(0,0) returns 0, (0,1) 1, (2,2) 8
        }

        private void union(int p, int q) {
            int proot = root(p);
            int qroot = root(q);
            if (sz[proot]<=sz[qroot]) {
                parent[proot] = qroot;
                sz[qroot] += sz[proot];
//                sz[proot] = 0;
            } else {
                parent[qroot] = proot;
                sz[proot] += sz[qroot];
//                sz[qroot] = 0;
            }
            countCC--;
        }

        private int getCountCC() {return countCC;}

        private List<Integer> getCCSizes() {
            List<Integer> s = new LinkedList<Integer>();
            for (int i=0; i<parent.length; i++) {
                if (parent[i]==i) {
                    s.add(sz[i]);
                }
            }
//            for (int size : sz) {
//                if(size>0) s.add(size);
//            }
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

//    private static int determineBasin(int[][] m, int i, int j) {
//        if (i==0&&j==0) return 0;
//
//        int basin;
//        int i_to;
//        int j_to;
//
//        Map<Integer, Cell> = new HashMap<Integer, Cell>()
//
//        if (i-1>=0 && m[i-1][j]<m[i][j]) {
//            i_to=i-1;
//            j_to=j;
//            basin=
//        }
//        m[i+1][j]
//        m[i][j-1]
//        m[i][j+1]
//    }

    private static class Cell {
        private int row;
        private int col;
        private int basin;
        private Cell(int row, int col, int basin) {
            this.row = row;
            this.col = col;
            this.basin = basin;
        }
    }
}
