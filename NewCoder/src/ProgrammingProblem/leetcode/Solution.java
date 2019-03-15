package ProgrammingProblem.leetcode;

import my.li.org.binary.TreeNode;

import java.math.BigInteger;
import java.util.*;

/**
 * Created by licheng on 8/25/18.
 */
public class Solution {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
        Solution solution = new Solution();

        System.out.println(solution.simplifyPath("/a//b////c/d//././/.."));
    }

    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        StringBuffer sb = new StringBuffer();
        for (String a : paths) {
            if (a.equals("") || a.equals(".")) {
                continue;
            } else if (a.equals("..")) {
                if (sb.length() > 1) {
                    sb.delete(sb.lastIndexOf("/"), sb.length());
                }
            } else {
                sb.append("/" + a);
            }
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }


    /**
     * 45. Jump Game II
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int level = 0;
        int curFarthest = 0;
        int i = 0;
        int nextMax = 0;

        //nodes count of current level>0
        while (curFarthest - i + 1 > 0) {
            level++;
            //traverse current level , and update the max reach of next level
            for (; i <= curFarthest; i++) {
                nextMax = Math.max(nextMax, nums[i] + i);
                if (nextMax >= nums.length - 1) {
                    // if last element is in level+1,  then the min jump=level
                    return level;
                }
            }
            curFarthest = nextMax;
        }
        return 0;
    }

    /**
     * 45. Jump Game II
     *
     * @param nums
     * @return
     */
    public int jump2(int[] nums) {
        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + nums[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }


    public static int sumOfFac(int n) {
        if (n < 1) {
            return 0;
        }
        BigInteger s = new BigInteger("1");
        int result = 0;
        for (int i = 1; i <= n; i++) {
            s = s.multiply(new BigInteger(String.valueOf(i)));
        }
        while (!s.equals(new BigInteger("0"))) {
            result = result + s.mod(new BigInteger("10")).intValue();
            s = s.divide(new BigInteger("10"));
        }
        return result;
    }

    public static int sumOfFac2(int n) {
        if (n < 1) {
            return 0;
        }
        int[] a = new int[1024];
        int result = 0;
        for (int i = 1; i <= n; i++) {

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
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (p.map[index] == null) {
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

    class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
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

    /**
     * 53. Maximum Subarray
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
            maxSoFar = Math.max(maxEndingHere, maxSoFar);
        }
        return maxSoFar;
    }

    /**
     * 102. Binary Tree Level Order Traversal
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int leversize = queue.size();
            List<Integer> leverlist = new ArrayList<>();
            for (int i = 0; i < leversize; i++) {
                TreeNode node = queue.poll();
                leverlist.add(node.data);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(leverlist);
        }
        return result;
    }

    /**
     * 104. Maximum Depth of Binary Tree
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(minDepth(root.left) + 1, minDepth(root.right) + 1);
    }

    /**
     * 111. Minimum Depth of Binary Tree
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        } else if (root.left == null) {
            return minDepth(root.right) + 1;
        } else if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        return Math.min(minDepth(root.left) + 1, minDepth(root.right) + 1);
    }

    /**
     * 112. Path Sum
     *
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.data == sum && root.left == null && root.right == null) {
            return true;
        }
        return hasPathSum(root.left, sum - root.data) || hasPathSum(root.right, sum - root.data);
    }

    public int maxPoints(Point[] points) {

        return 0;

    }

    /**
     * 124. Binary Tree Maximum Path Sum
     *
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.data;
        } else if (root.left == null) {
            return maxPathSum(root.right) + root.data;
        } else if (root.right == null) {
            return maxPathSum(root.left) + root.data;
        }
        return Math.max(maxPathSum(root.left) + root.data, maxPathSum(root.right) + root.data);

    }

    /**
     * 56. Merge Intervals
     *
     * @param intervals
     * @return
     */
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();

        return result;


    }

    /**
     * 103. Binary Tree Zigzag Level Order Traversal
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean zigzag = false;
        while (!queue.isEmpty()) {
            int leversize = queue.size();
            List<Integer> leverlist = new ArrayList<>();
            for (int i = 0; i < leversize; i++) {
                TreeNode node = queue.poll();
                leverlist.add(node.data);
                if (zigzag) {
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                } else {
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                }
            }
            result.add(leverlist);
            zigzag = !zigzag;
        }
        return result;

    }

    /**
     * 52. N-Queens II
     *
     * @param n
     * @return
     */
    public int totalNQueens(int n) {
        List<List<String>> list = new ArrayList<List<String>>();
        solveNQueensHelper(list, new ArrayList<>(), -1, n);
        return list.size();
    }

    private void totalNQueensHelper(List<List<String>> list, List<String> curList, int index, int n) {
        if (!check(curList, index, n)) {
            return;
        }
        if (index == (n * n) - 1) {
            if (countQ(curList) == n) {
                list.add(addList(curList, n));
            }
            return;
        }
        curList.add("Q");
        solveNQueensHelper(list, curList, index + 1, n);
        curList.remove(curList.size() - 1);
        curList.add(".");
        solveNQueensHelper(list, curList, index + 1, n);
        curList.remove(curList.size() - 1);
    }


    /**
     * 51. N-Queens
     *
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<List<String>>();
        List<String> curList = new ArrayList<>();
        solveNQueensHelper(list, curList, -1, n);
        return list;
    }

    private void solveNQueensHelper(List<List<String>> list, List<String> curList, int index, int n) {
        if (!check(curList, index, n)) {
            return;
        }
        if (index == (n * n) - 1) {
            if (countQ(curList) == n) {
                list.add(addList(curList, n));
            }
            return;
        }
        curList.add("Q");
        solveNQueensHelper(list, curList, index + 1, n);
        curList.remove(curList.size() - 1);
        curList.add(".");
        solveNQueensHelper(list, curList, index + 1, n);
        curList.remove(curList.size() - 1);
    }

    private List<String> addList(List<String> curList, int n) {
        if (curList.size() != n * n) {
            return null;
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder(n);
            for (int j = 0; j < n; j++) {
                sb.append(curList.get(i * n + j));
            }
            result.add(sb.toString());
            sb.delete(0, n);
        }
        return result;
    }

    private int countQ(List<String> curList) {
        int sum = 0;
        for (String str : curList) {
            if (str.equals("Q")) {
                sum++;
            }
        }
        return sum;
    }

    private boolean check(List<String> list, int index, int n) {
        if (list.size() == 0) {
            return true;
        }
        if (list.get(index).equals(".")) {
            return true;
        }
        int row = index / n;
        if (countQ(list) <= row) {
            return false;
        }
        int col = index % n;
        int count = 0;
        for (int i = 0; i <= row; i++) {
            if (list.get(i * n + col).equals("Q")) {
                count++;
            }
            if (count == 2) {
                return false;
            }
        }
        count = 0;
        for (int i = 0; i <= col; i++) {
            if (list.get(row * n + i).equals("Q")) {
                count++;
            }
            if (count == 2) {
                return false;
            }
        }
        count = 0;
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (list.get(i * n + j).equals("Q")) {
                count++;
            }
            if (count == 2) {
                return false;
            }
        }
        count = 0;
        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (list.get(i * n + j).equals("Q")) {
                count++;
            }
            if (count == 2) {
                return false;
            }
        }
        return true;
    }

    /**
     * 235. Lowest Common Ancestor of a Binary Search Tree
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestorofBST(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        if (root.data > p.data && root.data > q.data) {
            return lowestCommonAncestorofBST(root.left, p, q);
        } else if (root.data < p.data && root.data < q.data) {
            return lowestCommonAncestorofBST(root.right, p, q);
        }
        return root;
    }

    /**
     * 236. Lowest Common Ancestor of a Binary Tree
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }

    /**
     * 701. Insert into a Binary Search Tree
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.data > val) {
            if (root.left == null) {
                root.left = new TreeNode(val);
                return root;
            }
            insertIntoBST(root.left, val);
        } else if (root.data < val) {
            if (root.right == null) {
                root.right = new TreeNode(val);
                return root;
            }
            insertIntoBST(root.right, val);
        }
        return root;
    }

    /**
     * 62. Unique Paths
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0)
                    grid[i][j] = 1;
                else
                    grid[i][j] = grid[i][j - 1] + grid[i - 1][j];
            }
        }
        return grid[m - 1][n - 1];
    }

    /**
     * 700. Search in a Binary Search Tree
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode node = root;
        while (node != null && node.data != val) {
            if (node.data > val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return node;
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
