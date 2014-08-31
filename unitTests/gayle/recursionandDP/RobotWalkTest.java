package gayle.recursionandDP;

import junit.framework.Assert;
import org.junit.Test;

public class RobotWalkTest {

    @Test
    public void testCountWays() throws Exception {
        RobotWalk robotWalk = new RobotWalk(1,2);
        Assert.assertEquals(3, robotWalk.countWays(1,2));
    }
}