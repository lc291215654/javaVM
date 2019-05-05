package another4rProblem;

public class WordDictionary {

    WordNode root = new WordNode();

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {

    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        WordNode node = root;
        for (char c : word.toCharArray()) {
            if (node.next[c - 'a'] == null) {
                node.next[c - 'a'] = new WordNode();
            }
            node = node.next[c - 'a'];
        }
        node.item = word;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }

    public boolean match(char[] chs, int k, WordNode node) {
        if (k == chs.length) {
            return !node.item.equals("");
        }
        if (chs[k] != '.') {
            return node.next[chs[k] - 'a'] != null && match(chs, k + 1, node.next[chs[k] - 'a']);
        } else {
            for (int i = 0; i < node.next.length; i++) {
                if (node.next[i] != null) {
                    if (match(chs, k + 1, node.next[i])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    class WordNode {
        WordNode[] next = new WordNode[26];
        String item = "";
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */