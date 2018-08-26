package ProgrammingProblem.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by licheng on 8/25/18.
 */
public class Solution {

    public static void main(String args[]) {

    }

    class TrieNode {
        int path;
        int end;
        TrieNode[] map;

        public TrieNode() {
            path = 0;
            end = 0;
            map = new TrieNode[26];
        }

    }

    class Trie {
        /**
         * Initialize your data structure here.
         */
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            if (word == null) {
                return;
            }
            char[] chs = word.toCharArray();
            TrieNode p = root;
            int index = 0;
            for(int i=0;i<chs.length;i++){
                index = chs[i] - 'a';
                if(p.map[index] == null){
                    p.map[index] = new TrieNode();
                }
                p = p.map[index];
                p.path++;
            }
            p.end++;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {

            return false;

        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            return false;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        Set<String> result = new HashSet<>();
        for(String word:words){
            if(isExsts(board,word)){
                result.add(word);
            }
        }
        return new ArrayList<>(result);
    }

    public boolean isExsts(char[][] board, String words) {

        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, visited, i, j, words, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    List<String> result = new ArrayList<>();

    public boolean dfs(char[][] board, boolean[][] visit, int i, int j, String words, int k) {
        System.out.println("i:" + i +" j:" + j + " K:" + k);
        if (k == words.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        if (visit[i][j] == true) {
            return false;
        }
        if (board[i][j] != words.charAt(k)) {
            return false;
        }
        visit[i][j] = true;
        if (dfs(board, visit, i - 1, j, words, k+1) ||
                dfs(board, visit, i + 1, j, words, k+1) ||
                dfs(board, visit, i, j - 1, words, k+1) ||
                dfs(board, visit, i, j + 1, words, k+1)) {
            return true;
        }
        visit[i][j] = false;
        return false;
    }

}
