package dl.algorithm.c08slidewindow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) {
            return Collections.emptyList();
        }
        List<Integer> ans = new ArrayList<>();
        int target = 0;
        for (char x : p.toCharArray()) {
            target += code(x);
        }
        int l = p.length();
        int h = 0;
        for (int i = 0; i < l; i++) {
            h += code(s.charAt(i));
        }
        for (int i = l; i < s.length(); i++) {
            if (h == target) {
                ans.add(i - l);
            }
            h += code(s.charAt(i));
            h -= code(s.charAt(i - l));
        }
        if (h == target) {
            ans.add(s.length() - l);
        }
        return ans;
    }

    private int code(char c) {
        return c * c + 7;
    }
}
