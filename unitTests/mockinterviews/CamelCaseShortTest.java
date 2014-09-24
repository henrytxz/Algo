package mockinterviews;

import junit.framework.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertArrayEquals;

public class CamelCaseShortTest {

    @Test
    public void test1() {
        Map<String, String> d = new HashMap<String, String>();
        d.put("feed", "dummy definition");
        d.put("back", "dummy definition");
        d.put("good", "dummy definition");
        d.put("feedback", "dummy definition");
        d.put("go", "dummy definition");
        d.put("goo", "dummy definition");

        CamelCaseShort cc = new CamelCaseShort(d);
        List<String> list = cc.camelCase("goodfeedback");

        Assert.assertEquals(2, list.size());
        Assert.assertTrue(list.contains("GoodFeedBack"));
        Assert.assertTrue(list.contains("GoodFeedback"));
    }

    @Test
    public void test2() {
        Map<String, String> d = new HashMap<String, String>();
        d.put("good", "dummy definition");
        d.put("goo", "dummy definition");
        d.put("d", "dummy definition");

        d.put("go", "dummy definition");

        CamelCaseShort cc = new CamelCaseShort(d);
        List<String> list = cc.camelCase("good");

        Assert.assertEquals(2, list.size());
        Assert.assertTrue(list.contains("Good"));
        Assert.assertTrue(list.contains("GooD"));
    }

    @Test
    public void test3() {
        Map<String, String> d = new HashMap<String, String>();
        d.put("feed", "dummy definition");
        d.put("back", "dummy definition");
        d.put("good", "dummy definition");
        d.put("feedback", "dummy definition");
        d.put("go", "dummy definition");
        d.put("goo", "dummy definition");

        CamelCaseShort cc = new CamelCaseShort(d);
        List<String> list = cc.camelCase("odfeedback");

        Assert.assertEquals(0, list.size());
    }

    @Test
    public void test_getFirst() {
        Map<String, String> d = new HashMap<String, String>();
        d.put("feed", "dummy definition");
        d.put("back", "dummy definition");
        d.put("good", "dummy definition");
        d.put("feedback", "dummy definition");
        d.put("go", "dummy definition");
        d.put("goo", "dummy definition");

        CamelCaseShort cc = new CamelCaseShort(d);
        Assert.assertEquals("GoodFeedback", cc.getFirst("goodfeedback"));
    }

    @Test
    public void test_parse() {
        Map<String, String> d = new HashMap<String, String>();
        d.put("feed", "dummy definition");
        d.put("back", "dummy definition");
        d.put("good", "dummy definition");
        d.put("feedback", "dummy definition");
        d.put("go", "dummy definition");
        d.put("goo", "dummy definition");

        CamelCaseShort cc = new CamelCaseShort(d);
        List<String[]> list = cc.parse("goodfeedback");
        Assert.assertEquals(2, list.size());
        assertArrayEquals(new String[]{"Good","Feed","Back"}, list.get(0));
        assertArrayEquals(new String[]{"Good","Feedback"}, list.get(1));
    }
}