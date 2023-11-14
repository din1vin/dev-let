package dl.algorithm.c15trie;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumLengthEncoding {
    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words, Comparator.comparing(String::length).reversed());
        int res = 0;
        Trie trie = new Trie();
        for (String word : words) {
            boolean flag = false;
            int length = word.length();
            Trie node = trie;
            for (int i = length - 1; i >= 0; i--) {
                char c = word.charAt(i);
                int idx = c - 'a';
                if (node.children[idx] == null) {
                    flag = true;
                    node.children[idx] = new Trie();
                }
                node = node.children[idx];
            }
            if(flag){
                res += length + 1;
            }
        }
        return res;
    }


    class Trie {
        Trie[] children;

        public Trie() {
            this.children = new Trie[26];
        }
    }
}
