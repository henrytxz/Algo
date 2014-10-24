package interviews;

/**
 * Created by henry on 10/21/2014.
 */
public class Boggle {
    protected static boolean isNeighbor(Position p, Position last) {
        return (p.i==last.i && Math.abs(p.j-last.j)==1) || //same row, different column
                (Math.abs(p.i-last.i)==1 && p.j==last.j) || //different row, same column
                (Math.abs(p.i-last.i)==1 && Math.abs(p.j-last.j)==1); //diagonal
    }

    public static class Position {
        int i;
        int j;
        public Position(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Position) {
                Position that = (Position) obj;
                return i==that.i&&j==that.j;
            }
            return false;
        }

        /*
            needed this so HashSet contains will equate one (0,0) with another (0,0)
         */
        @Override
        public int hashCode() {
            return 17*i + 17*17*j;
        }
    }
}
