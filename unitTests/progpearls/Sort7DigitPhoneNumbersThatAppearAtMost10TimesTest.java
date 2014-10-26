package progpearls;

import junit.framework.Assert;
import org.junit.Test;

public class Sort7DigitPhoneNumbersThatAppearAtMost10TimesTest {
    @Test
    public void test_FourBit() {
        Sort7DigitPhoneNumbersThatAppearAtMost10Times probInstance = new Sort7DigitPhoneNumbersThatAppearAtMost10Times();
        Assert.assertEquals(0, probInstance.getCount(0));
        probInstance.incrementCount(0);
        Assert.assertEquals(1, probInstance.getCount(0));

        Assert.assertEquals(0, probInstance.getCount(9));
        probInstance.incrementCount(9);
        Assert.assertEquals(1, probInstance.getCount(9));
        probInstance.incrementCount(9);
        Assert.assertEquals(2, probInstance.getCount(9));
        probInstance.incrementCount(9);
        Assert.assertEquals(3, probInstance.getCount(9));
        probInstance.incrementCount(9);
        Assert.assertEquals(4, probInstance.getCount(9));
    }
}