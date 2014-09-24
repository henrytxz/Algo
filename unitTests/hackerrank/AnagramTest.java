package hackerrank;

import org.junit.Assert;
import org.junit.Test;

public class AnagramTest {

    @Test
    public void test_areAnagrams_1() throws Exception {
        Assert.assertTrue(Anagram.areAnagrams("the eyes", "they see"));
    }

    @Test
    public void test_areAnagrams_2() throws Exception {
        Assert.assertFalse(Anagram.areAnagrams("the eyes", "they see!"));
    }

    @Test
    public void test_areAnagrams_3() throws Exception {
        Assert.assertFalse(Anagram.areAnagrams("the eyes", "they do see"));
    }

    @Test
    public void test_areAnagrams_4() throws Exception {
        Assert.assertTrue(Anagram.areAnagrams("SCHOOL MASTER", "THE CLASSROOM"));
    }

    @Test
    public void test_areAnagrams_5() throws Exception {
        Assert.assertFalse(Anagram.areAnagrams("one sentence", "a different sentence"));
    }

    @Test
    public void test_areAnagramsInPlace_1() throws Exception {
        Assert.assertTrue(Anagram.inPlaceAreAnagrams("the eyes", "they see"));
    }

    @Test
    public void test_areAnagramsInPlace_2() throws Exception {
        Assert.assertFalse(Anagram.inPlaceAreAnagrams("the eyes", "they see!"));
    }

    @Test
    public void test_areAnagramsInPlace_3() { Assert.assertFalse(Anagram.inPlaceAreAnagrams("the eyes", "they do see")); }

    @Test
    public void test_areAnagramsInPlace_4() { Assert.assertTrue(Anagram.inPlaceAreAnagrams("SCHOOL MASTER", "THE CLASSROOM")); }

    @Test
    public void test_areAnagramsInPlace_5() { Assert.assertFalse(Anagram.inPlaceAreAnagrams("one sentence", "a different sentence")); }
}