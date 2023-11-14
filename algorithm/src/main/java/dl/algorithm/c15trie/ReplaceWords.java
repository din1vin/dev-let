package dl.algorithm.c15trie;

import org.junit.Test;

import java.util.List;
import java.util.StringJoiner;

public class ReplaceWords {
    class Trie26 {
        Trie26[] child;
        String str;

        public Trie26() {
            this.child = new Trie26[26];
            this.str = null;
        }

        public void insert(String str) {
            Trie26 node = this;
            for (char c : str.toCharArray()) {
                if (node.child[c - 'a'] == null) {
                    node.child[c - 'a'] = new Trie26();
                } else {
                    if (node.str != null) {
                        return;
                    }
                }
                node = node.child[c - 'a'];
            }
            node.str = str;
        }

        public String startsWith(String str) {
            Trie26 node = this;
            for (char c : str.toCharArray()) {
                if (node == null) return null;
                if (node.str != null) return node.str;
                node = node.child[c - 'a'];
            }
            return node == null ? null : node.str;
        }

    }

    public String replaceWords(List<String> dictionary, String sentence) {
        Trie26 trie26 = new Trie26();
        dictionary.forEach(trie26::insert);
        StringJoiner sj = new StringJoiner(" ");
        for (String s : sentence.split(" ")) {
            String root = trie26.startsWith(s);
            sj.add(root == null ? s : root);
        }
        return sj.toString();
    }

    @Test
    public void test() {
        List<String> dictionary = List.of("ab", "ac");
        String sentence = "it is abnormal that this solution is accepted";
        System.out.println(replaceWords(dictionary, sentence));
    }


}
