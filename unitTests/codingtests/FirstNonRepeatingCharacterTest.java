package codingtests;

import junit.framework.Assert;
import org.junit.Test;

public class FirstNonRepeatingCharacterTest {

    @Test
    public void testFirstNonRepeatingCharacter() throws Exception {
        Assert.assertEquals("O", FirstNonRepeatingCharacter.firstNonRepeatingCharacter("BANANABOAT"));
    }
}