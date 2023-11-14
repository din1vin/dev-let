package dl.algorithm.c15trie;

public class FindMaximumXOR {

    public int findMaximumXOR(int[] nums) {
        if (nums.length == 1) return nums[0];
        BinaryTrie trie = new BinaryTrie();
        trie.insert(nums[0]);
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, trie.search(nums[i]) ^ nums[i]);
            trie.insert(nums[i]);
        }
        return max;
    }


    class BinaryTrie {
        BinaryTrie[] child;

        public BinaryTrie() {
            child = new BinaryTrie[2];
        }

        public void insert(int num) {
            BinaryTrie node = this;
            for (int i = 30; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (node.child[bit] == null) {
                    node.child[bit] = new BinaryTrie();
                }
                node = node.child[bit];
            }
        }

        public int search(int num) {
            BinaryTrie node = this;
            int ans = 0;
            for (int i = 30; i >= 0; i--) {
                int bit = (num >> i) & 1;
                bit = node.child[bit ^ 1] == null ? bit : bit ^ 1;
                ans += bit << i;
                node = node.child[bit];
            }
            return ans;
        }
    }
}
