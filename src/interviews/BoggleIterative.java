package interviews;

import java.util.*;

/**
 * Created by henry on 10/20/2014.
 */
public class BoggleIterative extends Boggle {
    public static boolean matchWord(String word, char[][] grid) {
        /*
            handle bad input omitted
         */

        Map<Character, Set<Position>> m = new HashMap<Character, Set<Position>>();

        // the triple nested loop populates m
        for (int k=0; k!=word.length(); k++) {
//            if (m.get(word.charAt(k))!=null) break;
            for (int i=0; i!=4; i++) {
                for (int j=0; j!=4; j++) {
                    if (grid[i][j]==word.charAt(k)) {
                        if (word.length()==1) return true;
                        Set<Position> positionSet = m.get(grid[i][j]);
                        if (positionSet==null) {
                            positionSet = new HashSet<Position>();
                        }
                        Position p = new Position(i,j);
                        if (!positionSet.contains(p)) {
                            positionSet.add(p);
                        }
                        m.put(grid[i][j], positionSet);
                    }
                }
            }
            if (m.get(word.charAt(k))==null)
                return false;  //todo test
        }

        Set<List<Position>> oldPaths = new HashSet<List<Position>>();
        Set<Position> positionSet = m.get(word.charAt(0));

        // init oldPaths
        for (Position p : positionSet) {
            List<Position> path = new LinkedList<Position>();
            path.add(p);
            oldPaths.add(path);
        }

        Set<List<Position>> newPaths;

        // iteratively update newPaths
        for (int k=1; k!=word.length(); k++) {
            newPaths = new HashSet<List<Position>>();
            positionSet = m.get(word.charAt(k));
            for (Position p : positionSet) {
                for (List<Position> oldPath : oldPaths) {
                    Position last = oldPath.get(oldPath.size()-1);
                    if (isNeighbor(p, last) && !oldPath.contains(p)) {
                        List<Position> newPath = clonePath(oldPath);
                        newPath.add(p);
                        if (newPath.size()==word.length()) return true;
                        newPaths.add(newPath);
                    }
                }
            }
            oldPaths = newPaths;
        }
        return false;
    }

    protected static List<Position> clonePath(List<Position> oldPath) {
        List<Position> result = new LinkedList<Position>();
        for (Position p : oldPath) {
            result.add(p);
        }
        return result;
    }
}
