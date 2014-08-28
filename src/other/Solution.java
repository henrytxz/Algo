package other;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by henry on 8/26/2014.
 */
public class Solution {

    public Solution() {}
    public static void findBasins(BufferedReader br, String fileName) throws IOException {
        int dimension;
        String line = br.readLine();
        if (line!=null) {
            dimension = Integer.parseInt(line);
            int[][] m = new int[dimension][dimension];
            int[][] basins = new int[dimension][dimension];
            int row = 0;
//            List<List<Cell>> result = new ArrayList<List<Cell>>();

            Queue<Cell> markedCells = new ArrayDeque<Cell>();

            while ((line = br.readLine()) != null) {
                String[] a = line.split(" ");
                for (int j=0; j<dimension; j++) {
                    m[row][j] = Integer.parseInt(a[j]);
                }
                row++;
            }

            int basin = 1;	// use 1 to be different than all the 0
            for (int i=0; i<dimension; i++) {
                for (int j=0; j<dimension; j++) {
                    if(isSink(m, i, j)) {
                        basins[i][j] = basin;
                        markedCells.add(new Cell(i,j,basin));
                        basin++;
                    }
                }
            }

            while (markedCells.size()>0) {

            }

        } else {
            throw new IllegalArgumentException("no dimension found in file:"+fileName);
        }

//        if (br!=null&&br.isOpen?)   todo
        br.close();
    }

    public static void main(String[] args) throws IOException {
        if (args.length==0) throw new IllegalArgumentException("no file was provided");
        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        findBasins(br, args[0]);
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
