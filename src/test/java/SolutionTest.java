import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void longestStrChainTest1() {
        String[] words = {"a", "b", "ba", "bca", "bda", "bdca"};
        int expected = 4;
        int actual = new Solution().longestStrChain(words);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void longestStrChainTest2() {
        String[] words = {"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"};
        int expected = 5;
        int actual = new Solution().longestStrChain(words);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void longestStrChainTest3() {
        String[] words = {"abcd", "dbqca"};
        int expected = 1;
        int actual = new Solution().longestStrChain(words);

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void longestStrChainTest4() {
        String[] words = {"a","b","ba","abc","abd","bdca"};
        int expected = 2;
        int actual = new Solution().longestStrChain(words);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void longestStrChainTest5() {
        String[] words = {"xbc","pcxbcf","xb","cxbc","pcxbc"};
        int expected = 5;
        int actual = new Solution().longestStrChain(words);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isPredecessorTest1() {
        String current = "xbc";
        String next = "xbca";

        boolean actual = new Solution().isPredecessor(current, next);

        Assert.assertTrue(actual);
    }

    @Test
    public void isPredecessorTest2() {
        String current = "abcd";
        String next = "dbqca";

        boolean actual = new Solution().isPredecessor(current, next);

        Assert.assertFalse(actual);
    }
}
