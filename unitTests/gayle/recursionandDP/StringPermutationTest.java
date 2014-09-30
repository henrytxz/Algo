package gayle.recursionandDP;

import org.junit.Test;

import java.util.Set;

public class StringPermutationTest {

    @Test
    public void testAllPermutation1() throws Exception {
        Set<String> set = StringPermutation.allPermutation("abb");
        for (String s : set) {
            System.out.println(s);
        }
    }

    @Test
    public void testAllPermutation2() throws Exception {
        Set<String> set = StringPermutation.allPermutation("abc");
        for (String s : set) {
            System.out.println(s);
        }
    }
}