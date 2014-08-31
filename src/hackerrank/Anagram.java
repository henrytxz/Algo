package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

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

        if (isAnagram(s1, s2)) {
            System.out.println("Anagrams!");
        } else {
            System.out.println("Not anagrams!");
        }
    }

    public static boolean isAnagram(String s1, String s2) {
        char[] a1 = s1.toCharArray();
        Arrays.sort(a1);

        char[] a2 = s2.toCharArray();
        Arrays.sort(a2);

        return Arrays.equals(a1, a2);
    }
}
