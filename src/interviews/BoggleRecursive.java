package interviews;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by henry on 10/21/2014.
 */
public class BoggleRecursive extends Boggle {
    public static boolean matchWord(String w, char[][] grid, List<CharPositions> charPositionsList) {
        /*
            handle bad input omitted
         */

        Set<Position> found = findCharInGrid(w.charAt(0), grid);
        Set<Position> keep = keepAdjacentChars(found, charPositionsList);
        charPositionsList.add(new CharPositions(w.charAt(0), keep));
        if (keep.isEmpty()) return false;
        else {
            if (w.length()==1)
                return true;
            return matchWord(w.substring(1), grid, charPositionsList);
        }
    }

    private static Set<Position> keepAdjacentChars(Set<Position> found, List<CharPositions> charPositionsList) {
        Set<Position> result = new HashSet<Position>();
        if (charPositionsList.size()==0) return found;  //i.e. when we're looking for the 1st char, we keep the whole set
        Set<Position> positionsOfLastChar = charPositionsList.get(charPositionsList.size()-1).positions;
        for (Position p : found) {
            for (Position pLastChar : positionsOfLastChar) {
                if (isNeighbor(p, pLastChar)) result.add(p);
            }
        }
        return result;
    }

    private static Set<Position> findCharInGrid(char c, char[][] grid) {
        Set<Position> result = new HashSet<Position>();
        for (int i=0; i!=grid.length; i++) {
            for (int j=0; j!=grid[0].length; j++) {
                if (c==grid[i][j]) result.add(new Position(i,j));
            }
        }
        return result;
    }

    protected static class CharPositions {
        char c;
        Set<Position> positions;

        CharPositions(char c, Set<Position> positions) {
            this.c = c;
            this.positions = positions;
        }
    }
}
