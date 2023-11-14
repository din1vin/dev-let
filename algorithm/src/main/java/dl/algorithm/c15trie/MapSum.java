package dl.algorithm.c15trie;

import java.util.HashMap;
import java.util.Map;

public class MapSum {
    SumTrie root;
    Map<String, Integer> data;

    public MapSum() {
        this.root = new SumTrie();
        this.data = new HashMap<>();
    }

    public void insert(String key, int val) {
        int diff = val - this.data.getOrDefault(key, 0);
        this.data.put(key, val);
        SumTrie node = this.root;
        for (char c : key.toCharArray()) {
            int idx = c - 'a';
            if (node.child[idx] == null) {
                node.child[idx] = new SumTrie();
            }
            node.child[idx].val += diff;
            node = node.child[idx];
        }
    }

    public int sum(String prefix) {
        SumTrie node = this.root;
        for (char c : prefix.toCharArray()) {
            int idx = c - 'a';
            if (node.child[idx] == null) {
                return 0;
            }
            node = node.child[idx];
        }
        return node.val;
    }
}

class SumTrie {
    SumTrie[] child = new SumTrie[26];
    int val = 0;
}
