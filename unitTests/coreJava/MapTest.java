package coreJava;

import junit.framework.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by henry on 10/24/2014.
 */
public class MapTest {
    @Test
    public void test() {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(1,-1);
        map.put(1,1);
        Assert.assertEquals(1, map.get(1).intValue());
    }
}
