package dl.algorithm.c18backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class N04LetterCombinations {

    private List<String> ans = new ArrayList<>();
    private StringBuilder path = new StringBuilder();
    final String[] numbers = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    int len;
    String digits;

    public List<String> letterCombinations(String digits) {
        if (!digits.isEmpty()) {
            len = digits.length();
            this.digits = digits;
            backtracking(0);
        }
        return ans;
    }

    public void backtracking(int index) {

        if (index == len) {
            ans.add(path.toString());
            return;
        }
        int idx = digits.charAt(index) - '0';
        String s = numbers[idx];
        for (char c : s.toCharArray()) {
            path.append(c);
            backtracking(index + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }

    @Test
    public void test() {
        letterCombinations("23");
    }
}
