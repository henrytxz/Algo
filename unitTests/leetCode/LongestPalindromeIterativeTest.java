package leetCode;

import org.junit.Assert;
import org.junit.Test;

public class LongestPalindromeIterativeTest {

    @Test
    public void testFind() {
        String s = "!eye?";
        LongestPalindromeIterative lp = new LongestPalindromeIterative();
        Assert.assertEquals("eye", lp.find(s));
        System.out.println(lp.find(s));
    }

    @Test
    public void testFind2() {
        String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        System.out.println("s.length(): "+s.length());
        LongestPalindromeIterative lp = new LongestPalindromeIterative();
        final long startTime = System.currentTimeMillis();
        System.out.println(lp.find(s));
        final long endTime   = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime) );
    }

    /*
        my find(String s) takes 2 ms to run vs longestPalindrome2(String s) 11 ms!!!!!!
     */

    @Test
    public void testFind2Compare() {
        String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        final long startTime = System.currentTimeMillis();
        System.out.println(LongestPalindromeRecursive.longestPalindrome2(s));
        final long endTime   = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime) );
    }

    @Test
    public void testFind3() {
        String s = "bb";
        LongestPalindromeIterative lp = new LongestPalindromeIterative();
        Assert.assertEquals("bb", lp.find(s));
    }
}