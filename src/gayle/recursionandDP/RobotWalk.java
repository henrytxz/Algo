package gayle.recursionandDP;

/**
 * Created by henry on 8/29/2014.
 * Question 9.2 on p109
 */
public class RobotWalk {
    /*
        a robot is going from the upper left to lower right
        countWays(x,y) = countWays(x-1,y)+countWays(x,y-1)
    */
    int[][] numberOfWays;
    int result;

    public RobotWalk(int x, int y) {
        numberOfWays = new int[x+1][y+1];
        result = countWays(x, y);
    }

    public int countWays(int i, int j) {
        if (i<0 || j<0) return 0;
        else if (i==0 || j==0) return 1;
        else {
            if (numberOfWays[i][j]!=0) return numberOfWays[i][j];
            else {
                numberOfWays[i][j] = countWays(i-1,j) + countWays(i,j-1);
                return numberOfWays[i][j];
            }
        }
    }
}
