package ProgrammingProblem.leetcode;

import java.math.BigInteger;
import java.util.*;

/**
 * Created by licheng on 8/25/18.
 */
public class Solution {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int resutl = sumOfFac(n);
        System.out.println(resutl);
    }

    public static int sumOfFac(int n) {
        if(n < 1){
            return 0;
        }
        BigInteger s = new BigInteger("1");
        int result = 0;
        for(int i = 1 ;i<=n;i++){
            s = s.multiply(new BigInteger(String.valueOf(i)));
        }
        while (!s.equals(new BigInteger("0"))){
            result = result + s.mod(new BigInteger("10")).intValue();
            s = s.divide(new BigInteger("10"));
        }
        return result;
    }

    public static int sumOfFac2(int n) {
        if(n < 1){
            return 0;
        }
        int[] a = new int[1024];
        int result = 0;
        for(int i = 1 ;i<=n;i++){

        }
        return result;
    }


    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        int N = quality.length;
        double ans = 1e9;
        for (int captain = 0; captain < N; ++captain) {
            // Must pay at least wage[captain] / quality[captain] per qual
            double factor = (double) wage[captain] / quality[captain];
            double prices[] = new double[N];
            int t = 0;
            for (int worker = 0; worker < N; ++worker) {
                double price = factor * quality[worker];
                if (price < wage[worker]) continue;
                prices[t++] = price;
            }
            if (t < K) continue;
            Arrays.sort(prices, 0, t);
            double cand = 0;
            for (int i = 0; i < K; ++i)
                cand += prices[i];
            ans = Math.min(ans, cand);
        }
        return ans;
    }

    public int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }

    public boolean canJump(int[] nums) {
        boolean[] canReach = new boolean[nums.length];
        canReach[0] = true;
        for (int i = 0; i < nums.length; i++) {
            if (canReach[i] == false) {
                return false;
            }
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j < nums.length) {
                    canReach[i + j] = true;
                }
            }
        }
        return true;
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
        for (String word : words) {
            if (isExsts(board, word)) {
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

//    List<String> result = new ArrayList<>();

    public boolean dfs(char[][] board, boolean[][] visit, int i, int j, String words, int k) {
        System.out.println("i:" + i + " j:" + j + " K:" + k);
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
        if (dfs(board, visit, i - 1, j, words, k + 1) ||
                dfs(board, visit, i + 1, j, words, k + 1) ||
                dfs(board, visit, i, j - 1, words, k + 1) ||
                dfs(board, visit, i, j + 1, words, k + 1)) {
            return true;
        }
        visit[i][j] = false;
        return false;
    }

}
