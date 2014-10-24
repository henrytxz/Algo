package leetCode;

import org.junit.Assert;
import org.junit.Test;

public class LongestPalindromeRecursiveTest {

    @Test
    public void testFind() {
        String s = "!eye?";
        LongestPalindromeRecursive lp = new LongestPalindromeRecursive();
        Assert.assertEquals("eye", lp.find(s));
    }

    @Test
    public void testFind2() {
        String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        System.out.println("s.length(): "+s.length());
        LongestPalindromeRecursive lp = new LongestPalindromeRecursive();
        final long startTime = System.currentTimeMillis();
        System.out.println(lp.find(s));
        final long endTime   = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime) );
    }

    /*
        verdict: my find(String s) takes > 900 ms to run vs longestPalindrome2(String s) 11 ms. This means I can do better and so I will! =)
     */

    @Test
    public void testFind2Compare() {
        String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        final long startTime = System.currentTimeMillis();
        System.out.println(LongestPalindromeRecursive.longestPalindrome2(s));
        final long endTime   = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime) );
    }
}