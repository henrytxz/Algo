package mockinterviews;

import org.junit.Test;

public class DieHardTest extends DieHard {

    @Test
    public void testGetPossibleStates() throws Exception {
        DieHard dh = new DieHard(4, new int[]{1,5});
        State doneState = dh.makeAState(new int[]{0,4});
        System.out.println(dh.getPossibleStates(doneState));
    }

    @Test
    public void testGetPossibleStates2() throws Exception {
        DieHard dh = new DieHard(4, new int[]{1,5});
        State doneState = dh.makeAState(new int[]{1,4});
        System.out.println(dh.getPossibleStates(doneState));
    }

}