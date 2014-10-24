package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
    https://oj.leetcode.com/problems/triangle/

    Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

    For example, given the following triangle
    [
    [2],
    [3,4],
    [6,5,7],
    [4,1,8,3]
    ]
    The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

    Note:
    Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */
public class Triangle {
    public static int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> latestSums = new ArrayList<Integer>();
        latestSums.add(0); //row -1 so the following loop can work
        for (int i=0; i!=triangle.size(); i++) {
            List<Integer> newSums = new ArrayList<Integer>();
            for (int j=0; j!=triangle.get(i).size(); j++) {
                int curr = triangle.get(i).get(j);
                int sum1 = Integer.MAX_VALUE;
                int sum2 = Integer.MAX_VALUE;
                if (j-1>=0) sum1 = latestSums.get(j-1)+curr;
                if (j<latestSums.size()) sum2 = latestSums.get(j)+curr;
                newSums.add(Math.min(sum1, sum2));
            }
            latestSums=newSums;
        }

        int min = Integer.MAX_VALUE;
        for (int i=0; i!=latestSums.size(); i++) {
            if (latestSums.get(i)<min) min = latestSums.get(i);
        }

        return min;
    }

    /*
        X Wang's solution
        http://www.programcreek.com/2013/01/leetcode-triangle-java/
    */
}
