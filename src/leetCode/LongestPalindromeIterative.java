package leetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by henry on 10/17/2014.
 */
public class LongestPalindromeIterative {
    private int maxLen;
    private String longest;

    public String find(String s) {
        if (s==null || s.length()<=1) return s;
        maxLen=1;
        List<Palindrome> oddPs  = new LinkedList<Palindrome>();
        List<Palindrome> evenPs = new LinkedList<Palindrome>();
        for (int i=0; i!=s.length(); i++) {
            oddPs.add(new Palindrome(i,1));
        }
        for (int i=0; i!=s.length()-1; i++) {
            if (s.charAt(i)==s.charAt(i+1)) {
                evenPs.add(new Palindrome(i, 2));
                maxLen = 2;
                longest = s.substring(i, i+2);
            }
        }
        while (oddPs.size()>0 && oddPs.get(0).length+2<=s.length()) {
            oddPs = updateListOfPalindromes(s, oddPs);
        }
        while (evenPs.size()>0 && evenPs.get(0).length+2<=s.length()) {
            evenPs = updateListOfPalindromes(s, evenPs);
        }
        return longest;
    }

    private List<Palindrome> updateListOfPalindromes(String s, List<Palindrome> l) {
        List<Palindrome> result = new LinkedList<Palindrome>();
        for (Palindrome p : l) {
            int begin = p.beginIndex; int end = p.beginIndex+p.length-1;
            if (begin-1>-1 && end+1<s.length() && s.charAt(begin-1)==s.charAt(end+1))             {
                result.add(new Palindrome(begin-1, p.length+2));
                if (p.length+2 > maxLen) {
                    maxLen = p.length+2;
                    longest = s.substring(begin-1, end+1+1);
                }
            }
        }
        return result;
    }

    private static class Palindrome {
        int beginIndex;
        int length;
        Palindrome(int beginIndex, int length) {
            this.beginIndex = beginIndex;
            this.length = length;
        }
    }
}
