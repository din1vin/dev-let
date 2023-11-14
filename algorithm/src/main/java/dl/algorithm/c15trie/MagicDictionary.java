package dl.algorithm.c15trie;

public class MagicDictionary {
    Trie root;

    public MagicDictionary(Trie root) {
        this.root = root;
    }

    public void buildDict(String[] dictionary) {
        for (String s : dictionary) {
            Trie node = root;
            for (char c : s.toCharArray()) {
                int idx = c - 'a';
                if (node.child[idx] == null) {
                    node.child[idx] = new Trie();
                }
                node = node.child[idx];
            }
            node.isFinished = true;
        }
    }

    public boolean search(String searchWord) {
        return dfs(root, searchWord, 0, false);
    }

    private boolean dfs(Trie node, String word, int pos, boolean modified) {
        if (pos == word.length()) return modified && node.isFinished;
        int idx = word.charAt(pos) - 'a';
        if (node.child[idx] != null) {
            if (dfs(node.child[idx], word, pos + 1, false)) {
                return true;
            }
        }
        if (!modified) {
            for (int i = 0; i < 26; ++i) {
                if (i != idx && node.child[i] != null) {
                    if (dfs(node.child[i], word, pos + 1, true)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    class Trie {
        boolean isFinished;
        Trie[] child;

        public Trie() {
            isFinished = false;
            child = new Trie[26];
        }
    }
}


