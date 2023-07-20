package dl.algorithm.c09doublepointer;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int[] meet = new int[128];
        int ans = 0, left = 0;
        for (int right = 0; right < s.length(); right++) {
            char x = s.charAt(right);
            meet[x]++;
            while (meet[x] > 1) {
                meet[s.charAt(left++)]--;
            }
            ans = Math.max(right - left + 1, ans);
        }
        return ans;
    }

}
