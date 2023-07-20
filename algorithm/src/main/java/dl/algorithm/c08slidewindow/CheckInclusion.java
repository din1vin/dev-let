package dl.algorithm.c08slidewindow;

public class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int target = 0;
        for (char x : s1.toCharArray()) {
            target += code(x);
        }

        int l = s1.length();
        int h = 0;
        for (int i = 0; i < l; i++) {
            char c = s2.charAt(i);
            h += code(c);
        }
        for (int i = l; i < s2.length(); i++) {
            if (h == target) return true;
            char c = s2.charAt(i - l);
            h -= code(c);
            char c2 = s2.charAt(i);
            h += code(c2);
        }
        return h == target;
    }

    //设计一个自定义哈希函数
    private int code(char c) {
        return  c*c +7;
    }

}
