package dl.algorithm.c11hashtable;

import java.util.HashMap;

public class IsAlienSorted {
    private HashMap<Character, Integer> weight = new HashMap<>(26);

    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < order.toCharArray().length; i++) {
            weight.put(order.charAt(i), i);
        }
        for (int i = 0, j = 1; j < words.length; i++, j++) {
            if (bigger(words[i], words[j])) return false;
        }
        return true;
    }

    public boolean bigger(String s1, String s2) {
        int s = Math.min(s1.length(), s2.length());
        for (int i = 0; i < s; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 != c2) {
                return weight.get(c1) > weight.get(c2);
            }
        }
        return s1.length() > s2.length();
    }

    public static void main(String[] args) {
        IsAlienSorted isAlienSorted = new IsAlienSorted();
        String[] words = {"word", "world", "row"};
        String order = "worldabcefghijkmnpqstuvxyz";
        isAlienSorted.isAlienSorted(words, order);
    }
}
