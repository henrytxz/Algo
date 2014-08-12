package guava;

import com.google.common.base.Optional;
import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by henry on 8/12/2014.
 */
public class OptionalTest {
    @Test
    public void test() {
        Optional<Integer> possible = Optional.of(5);
        Assert.assertTrue(possible.isPresent());
        Assert.assertEquals(5, possible.get().intValue());
    }

    @Test (expected = NullPointerException.class)
    public void test_fail() {
        Optional<Integer> possible = Optional.of(null);
    }
}
