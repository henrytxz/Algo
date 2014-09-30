package gayle.recursionandDP;

import java.util.Set;
import java.util.Stack;

/**
 * Created by henry on 9/30/2014.
 * question 9.6 on p110
 */
public class ValidParentheses {
    public static void validParen(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i!=n; i++) {
            sb.append("()");
        }
        Set<String> allPermutations = StringPermutation.allPermutation(sb.toString());
        for (String s : allPermutations) {
            if (isValidParenthesis(s)) System.out.println(s);
        }
    }

    public static boolean isValidParenthesis(String s) {
        Stack<Character> openParenStack = new Stack<Character>();
        for (int i=0; i!=s.length(); i++) {
            if (openParenStack.isEmpty() && s.charAt(i)==')') return false;

            if (s.charAt(i)=='(') openParenStack.push('(');
            else openParenStack.pop();
        }
        return true;
    }
}
