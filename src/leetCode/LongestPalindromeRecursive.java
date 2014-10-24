package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by henry on 10/17/2014.
 */
public class LongestPalindromeRecursive {
    private int maxLen = 0;
    private Map<String, String> m = new HashMap<String, String>();

    public String find(String s) {
        if (s==null || s.length()<=1) return s;
        if (s.length()<maxLen) return "";
        if (m.get(s)!=null) return m.get(s);
        if (isPalindrome(s)) {
            if (s.length()>maxLen) maxLen = s.length();
            m.put(s, s);
            return s;
        }
        String s1 = find(s.substring(0, s.length()-1));
        String s2 = find(s.substring(1));
        if (s1.length()<s2.length()) {
            m.put(s, s2);
            return s2;
        } else {
            m.put(s, s1);
            return s1;
        }
    }

    private boolean isPalindrome(String s) {
        if (s==null || s.length()==0) return false;
        char[] a = s.toCharArray();
        int i = 0;
        int j = a.length-1;
        while (i<=j) {
            if (a[i++]!=a[j--]) return false;
        }
        return true;
    }

    /*========================================================================================================================*/
    /*
        copying a solution from http://www.programcreek.com/2013/12/leetcode-solution-of-longest-palindromic-substring-java/
        to see if it runs faster than my implementation
     */
    public static String longestPalindrome2(String s) {
        if (s == null)
            return null;

        if(s.length() <=1)
            return s;

        int maxLen = 0;
        String longestStr = null;

        int length = s.length();

        int[][] table = new int[length][length];

        //every single letter is palindrome
        for (int i = 0; i < length; i++) {
            table[i][i] = 1;
        }
        printTable(table);

        //e.g. bcba
        //two consecutive same letters are palindrome
        for (int i = 0; i <= length - 2; i++) {
            if (s.charAt(i) == s.charAt(i + 1)){
                table[i][i + 1] = 1;
                longestStr = s.substring(i, i + 2);
            }
        }
        printTable(table);
        //condition for calculate whole table
        for (int l = 3; l <= length; l++) {
            for (int i = 0; i <= length-l; i++) {
                int j = i + l - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    table[i][j] = table[i + 1][j - 1];
                    if (table[i][j] == 1 && l > maxLen)
                        longestStr = s.substring(i, j + 1);
                } else {
                    table[i][j] = 0;
                }
                printTable(table);
            }
        }

        return longestStr;
    }
    public static void printTable(int[][] x){
//        for(int [] y : x){
//            for(int z: y){
//                System.out.print(z + " ");
//            }
//            System.out.println();
//        }
//        System.out.println("------");
    }

}
