package dl.algorithm.c18backtracking;

import java.util.ArrayList;
import java.util.List;

public class N07RestoreIpAddresses {
    private List<String> ans = new ArrayList<>();
    private List<String> path = new ArrayList<>();
    String s;

    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12) return new ArrayList<>();
        this.s = s;
        backTracking(0);
        return ans;
    }

    private void backTracking(int startIndex) {
        if (path.size() > 4) return;
        if (path.size() == 4 && startIndex == s.length()) {
            ans.add(String.join(".", path));
            return;
        }

        for (int i = startIndex, l = s.length(); i < l; i++) {
            String subStr = s.substring(startIndex, i + 1);
            if (!isValid(subStr)) continue;
            path.add(subStr);
            backTracking(i + 1);
            path.remove(path.size() - 1);
        }

    }

    private boolean isValid(String number) {
        if (number.length() > 3) return false;
        if (number.length() > 1 && number.startsWith("0")) return false;
        return Integer.parseInt(number) < 256;
    }
}
