package dl.algorithm.c10windowincrease;

public class CountSubstrings {
    public int countSubstrings(String s) {
        int ans = 0;
        //奇数长度回文串,i为中心点
        int l = s.length();
        for (int i = 0; i < s.length(); i++) {
            ans++;
            int left = i - 1;
            int right = i + 1;
            while (left >= 0 && right < l) {
                if (s.charAt(left--) != s.charAt(right++)) {
                    break;
                }
                ans++;
            }
        }

        // 偶数长度的回文串, i,i+1为中心;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                continue;
            }
            ans++;
            int left = i - 1;
            int right = i + 2;
            while (left >= 0 && right < l) {
                if (s.charAt(left--) != s.charAt(right++)) {
                    break;
                }
                ans++;
            }
        }

        return ans;
    }
}
