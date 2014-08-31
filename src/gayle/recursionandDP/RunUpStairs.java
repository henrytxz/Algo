package gayle.recursionandDP;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by henry on 8/29/2014.
 * Question 9.1 on p109
 */

public class RunUpStairs {

    private List<Integer> numberOfWays;

    public RunUpStairs() {
        numberOfWays = new ArrayList<Integer>();
    }

    public int count(int n) {
        if (n < 0) return 0;
        else if (n==0) return 1;    //this is so count(1) = count(0) would work
        else if (n<numberOfWays.size()) //avoids index out of bound exception
            return numberOfWays.get(n);

        int result = count(n-1)+count(n-2)+count(n-3);

        numberOfWays.add(n-1, result);
        return result;
    }
}
