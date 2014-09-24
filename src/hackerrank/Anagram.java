package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by henry on 8/28/2014.
 */
public class Anagram {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        if (s1==null || s1.length()==0) {
            System.out.println("no string was inputed, try again!");
            return;
        }
        String s2 = br.readLine();
        if (s2==null || s2.length()==0) {
            System.out.println("didn't receive a 2nd string, try again!");
            return;
        }

        if (areAnagrams(s1, s2)) {
            System.out.println("Anagrams!");
        } else {
            System.out.println("Not anagrams!");
        }
    }

    public static boolean areAnagrams(String s1, String s2) {
        char[] a1 = s1.toCharArray();
        Arrays.sort(a1);

        char[] a2 = s2.toCharArray();
        Arrays.sort(a2);

        return Arrays.equals(a1, a2);
    }

    /*
        O(n) time and O(n) space - only one map instead of two
     */
    public static boolean inPlaceAreAnagrams(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        Map<Character, Integer> m = new HashMap<Character, Integer>();
        char[] a = s1.toCharArray();
        for (int i=0; i<a.length; i++) {
            Integer count = m.get(a[i]);
            if (count==null) m.put(a[i], 1);
            else m.put(a[i], count+1);
        }
        char[] a2 = s2.toCharArray();
        for (int i=0; i<a2.length; i++) {
            Integer count = m.get(a2[i]);
            if (count==null)    //a char is in s2 but not in s1
                return false;
            else {
                if (count==1) m.remove(a2[i]);
                else m.put(a2[i], count-1);
            }
        }
        return m.isEmpty();
    }
}
