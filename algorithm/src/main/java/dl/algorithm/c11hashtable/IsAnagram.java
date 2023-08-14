package dl.algorithm.c11hashtable;

public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        if(s.equals(t)) return false;
        int[] memory = new int[26];
        for (char c : s.toCharArray()) {
            memory[c - 'a']++;
        }
        for(char c: t.toCharArray()){
            memory[c-'a']--;
            if(memory[c-'a']<0) return false;
        }
        for (int i : memory) {
            if(i!=0) return false;
        }
        return true;
    }
}
