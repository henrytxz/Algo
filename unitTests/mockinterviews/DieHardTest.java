package mockinterviews;

import junit.framework.Assert;
import org.junit.Test;

public class DieHardTest extends DieHard {

    @Test
    public void testGetPossibleStates() throws Exception {
        DieHard dh = new DieHard(4, new int[]{1,5});
        State doneState = dh.makeAState(new int[]{0, 4});
        System.out.println(dh.getPossibleStates(doneState));
    }

    @Test
    public void testGetPossibleStates2() throws Exception {
        DieHard dh = new DieHard(4, new int[]{1,5});
        State doneState = dh.makeAState(new int[]{1,4});
        System.out.println(dh.getPossibleStates(doneState));
    }

    @Test
    public void testGetPossibleStates3() throws Exception {
        DieHard dh = new DieHard(4, new int[]{1,5});
        State doneState = dh.makeAState(new int[]{1,3});
        System.out.println("test3");
        System.out.println(dh.getPossibleStates(doneState));
    }

    @Test
    public void test() throws Exception {
        DieHard dh = new DieHard(2, new int[]{1,3});
        dh.printGoodPaths();
    }

    @Test
    public void test_isGood() {
        DieHard dh = new DieHard(2, new int[]{1,3});
        State s = dh.makeAState(new int[]{0,0});
        Assert.assertTrue(s.isGood());
    }

    @Test
    public void test_isReversible() throws Exception {
        DieHard dh = new DieHard(4, new int[]{1,5});
//        State s1 = dh.makeAState(new int[]{0,4});
        System.out.println("starting test");
//        System.out.println(dh.getPossibleStates(s1));

        State s2 = dh.makeAState(new int[]{1,3});
        System.out.println(dh.getPossibleStates(s2));
//        System.out.println(dh.isReversible(s1, s2));
    }

}