package hackerrank;

import org.junit.Assert;
import org.junit.Test;

public class AnagramTest {

    @Test
    public void testIsAnagram1() throws Exception {
        Assert.assertTrue(Anagram.isAnagram("the eyes", "they see"));
    }

    @Test
    public void testIsAnagram2() throws Exception {
        Assert.assertFalse(Anagram.isAnagram("the eyes", "they see!"));
    }

    @Test
    public void testIsAnagram3() throws Exception {
        Assert.assertFalse(Anagram.isAnagram("the eyes", "they do see"));
    }

    @Test
    public void testIsAnagram4() throws Exception {
        Assert.assertTrue(Anagram.isAnagram("SCHOOL MASTER", "THE CLASSROOM"));
    }

    @Test
    public void testIsAnagram5() throws Exception {
        Assert.assertFalse(Anagram.isAnagram("one sentence", "a different sentence"));
    }
    
}