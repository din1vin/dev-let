package dl.algorithm.c18backtracking;

import java.util.ArrayList;
import java.util.List;

public class N06Partition {

    final List<List<String>> ans = new ArrayList<>();
    final List<String> path = new ArrayList<>();
    String s;


    public String[][] partition(String s) {
        this.s = s;
        backtracking(0);
        return ans.stream()
                .map(x -> x.toArray(String[]::new))
                .toArray(String[][]::new);
    }

    private void backtracking(int startIndex) {
        if (startIndex == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            if (!isPalindrome(startIndex, i)) continue;
            path.add(s.substring(startIndex, i + 1));
            backtracking(i + 1);
            path.remove(path.size() - 1);
        }

    }


    private boolean isPalindrome(int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            if (s.charAt(startIndex++) != s.charAt(endIndex--))
                return false;
        }
        return true;
    }
}
