package ProgrammingProblem.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by licheng on 8/25/18.
 */
public class Solution {

    public static void main(String args[]) {

    }
    class TrieNode{
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
            if(word == null){
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

        List<String> result = new ArrayList<>();
        for(String word:words){
            if (findword(word)){
                result.add(word);
            }
        }
        return null;
    }

    private boolean findword(String word) {

        return false;
    }

}
