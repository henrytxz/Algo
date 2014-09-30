package gayle.recursionandDP;

import junit.framework.Assert;
import org.junit.Test;

public class ValidParenthesesTest {

    @Test
    public void test() {
        ValidParentheses.validParen(3);
    }

    @Test
    public void testIsValidParenthesis() throws Exception {
        Assert.assertTrue(ValidParentheses.isValidParenthesis("(())"));
        Assert.assertTrue(ValidParentheses.isValidParenthesis("()()"));
        Assert.assertFalse(ValidParentheses.isValidParenthesis("())("));
        Assert.assertFalse(ValidParentheses.isValidParenthesis(")(()"));
        Assert.assertFalse(ValidParentheses.isValidParenthesis("))(("));
        Assert.assertFalse(ValidParentheses.isValidParenthesis(")()("));
    }
}