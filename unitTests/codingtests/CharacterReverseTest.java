package codingtests;

import junit.framework.Assert;
import org.junit.Test;

public class CharacterReverseTest {

    @Test
    public void testCharacterReverse() throws Exception {
        Assert.assertEquals("hhtt", CharacterReverse.characterReverse("tthh"));
        Assert.assertEquals("hhtt", CharacterReverse.characterReverse("thth"));
    }
}