package ProgrammingProblem;


import my.li.org.binary.TreeNode;

import java.util.*;

/**
 * Created by licheng on 7/4/18.
 */

//  *word-break*
//  Given a string s and a dictionary of words dict, determine
// if s can be segmented into a space-separated sequence of
// one or more dictionary words.
//
//  For example, given
//  s ="leetcode",
//  dict =["leet", "code"].
//
//  Return true because"leetcode"can be segmented as"leet code".

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

public class Solution {
    LinkedList<Integer> list = new LinkedList<Integer>();
    private int index = 0;
    private HashSet<Character> charset = new HashSet<>();
    private LinkedList<Character> charlist = new LinkedList<Character>();

    public static void main(String args[]) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(9);
        ListNode node3 = new ListNode(9);
        ListNode node4 = new ListNode(9);
        ListNode node5 = new ListNode(9);
        ListNode node6 = new ListNode(9);
        ListNode node7 = new ListNode(9);
        ListNode node8 = new ListNode(9);
        ListNode node9 = new ListNode(9);
        ListNode node10 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;

        ListNode node20 = new ListNode(9);

        Solution solution = new Solution();
        System.out.println();
        TreeNode root = solution.levMidRestore(new int[]{3, 5, 4, 2, 6, 7, 1}, new int[]{2, 5, 3, 6, 4, 7, 1});
        solution.preorderTraversal(root);
//        solution.postorderTraversal(root);
//        boolean rr = solution.searchMatrix(new int[][]{{1,3,5,7},
//                {10, 11, 16, 20},
//                {23, 30, 34, 50}},34);


//        int rr = solution.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"});
//        System.out.println(rr);

    }

    private static int treeheight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = treeheight(root.left);
        int right = treeheight(root.right);
        return left > right ? left + 1 : right + 1;
    }

    public static void Combination() {
        /*基本思路：求全组合，则假设原有元素n个，则最终组合结果是2^n个。原因是：
         * 用位操作方法：假设元素原本有：a,b,c三个，则1表示取该元素，0表示不取。故去a则是001，取ab则是011.
         * 所以一共三位，每个位上有两个选择0,1.所以是2^n个结果。
         * 这些结果的位图值都是0,1,2....2^n。所以可以类似全真表一样，从值0到值2^n依次输出结果：即：
         * 000,001,010,011,100,101,110,111 。对应输出组合结果为：
        空,a, b ,ab,c,ac,bc,abc.
        这个输出顺序刚好跟数字0~2^n结果递增顺序一样
        取法的二进制数其实就是从0到2^n-1的十进制数
         * ******************************************************************
         * *
         * */
        String[] str = {"a", "b", "c"};
        int n = str.length;                                  //元素个数。
        //求出位图全组合的结果个数：2^n
        int nbit = 1 << n;                                     // “<<” 表示 左移:各二进位全部左移若干位，高位丢弃，低位补0。:即求出2^n=2Bit。
        System.out.println("全组合结果个数为：" + nbit);

        for (int i = 0; i < nbit; i++) {                        //结果有nbit个。输出结果从数字小到大输出：即输出0,1,2,3,....2^n。
            System.out.print("组合数值  " + i + " 对应编码为： ");
            for (int j = 0; j < n; j++) {                        //每个数二进制最多可以左移n次，即遍历完所有可能的变化新二进制数值了
                int tmp = 1 << j;
                if ((tmp & i) != 0) {                            //& 表示与。两个位都为1时，结果才为1
                    System.out.print(str[j]);
                }
            }
            System.out.println();
        }
    }

    int find(int[] num, int k) {
        for (int i = 0; i < num.length; i++) {
            if (num[i] == k) {
                return i;
            }
        }
        return -1;
    }

    TreeNode levMidRestore(int[] lev, int[] mid) {
        int size = lev.length;
        TreeNode[] helper = new TreeNode[size];
        boolean success = false;
        TreeNode root = new TreeNode(lev[0]);
        int mi = find(mid, lev[0]);
        helper[mi] = root;
        for (int i = 1; i < lev.length; i++) {
            success = false;
            mi = find(mid, lev[i]);
            helper[mi] = new TreeNode(lev[i]);
            for (int p = mi - 1; p >= 0; p--) {
                if (helper[p] != null) {
                    if (helper[p].right == null) {
                        helper[p].right = helper[mi];
                        success = true;
                    }
                    break;
                }
            }
            if (success) {
                continue;
            }
            for (int p = mi + 1; p < size; p++) {
                if (helper[p] != null) {
                    if (helper[p].left == null) {
                        helper[p].left = helper[mi];
                        success = true;
                    }
                    break;
                }
            }
            if (!success) {
                break;
            }
        }
        return root;
    }

    public boolean match(char[] str, char[] pattern) {
        if (str == null && pattern == null) {
            return true;
        }
        if (str != null && pattern == null) {
            return false;
        }

        return false;


    }

    String Serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        if (root == null) {
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.data + ",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();

    }

    /**
     * 93. Restore IP Addresses
     *
     * @param s
     * @return
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        int len = s.length();
        for (int i = 1; i < 4 && i < len - 2; i++) {
            for (int j = i + 1; j < i + 4 && j < len - 1; j++) {
                for (int k = j + 1; k < j + 4 && k < len; k++) {
                    String s1 = s.substring(0, i), s2 = s.substring(i, j), s3 = s.substring(j, k), s4 = s.substring(k, len);
                    if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
                        res.add(s1 + "." + s2 + "." + s3 + "." + s4);
                    }
                }
            }
        }
        return res;
    }

    public boolean isValid(String s) {
        if (s.length() > 3 || s.length() == 0 || (s.charAt(0) == '0' && s.length() > 1) || Integer.parseInt(s) > 255)
            return false;
        return true;
    }

    /**
     * 240. Search a 2D Matrix II
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int i = m - 1;
        int j = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                i--;
            } else {
                j++;
            }
        }
        return false;
    }

    /**
     * 74. Search a 2D Matrix
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[m - 1][n - 1]) {
            return false;
        }
        int low = 0;
        int high = m - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] > target) {
                high = mid - 1;
            } else if (matrix[mid][0] < target && target <= matrix[mid][n - 1]) {
                low = mid;
                break;
            } else {
                low = mid + 1;
            }
        }
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (matrix[low][mid] == target) {
                return true;
            } else if (matrix[low][mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    /**
     * 73. Set Matrix Zeroes
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int col0 = 1, rows = matrix.length, cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) col0 = 0;
            for (int j = 1; j < cols; j++)
                if (matrix[i][j] == 0)
                    matrix[i][0] = matrix[0][j] = 0;
        }
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 1; j--)
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            if (col0 == 0) matrix[i][0] = 0;
        }

    }

    TreeNode Deserialize(String str) {
        index++;
        int len = str.length();
        if (index >= len) {
            return null;
        }
        String[] strr = str.split(",");
        TreeNode node = null;
        if (!strr[index].equals("#")) {
            node = new TreeNode(Integer.valueOf(strr[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }

        return node;

    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode p = head.next;
        ListNode pstart = new ListNode(0);
        ListNode pend = head;
        pstart.next = head;
        while (p != null) {
            ListNode tmp = pstart.next;
            ListNode pre = pstart;
            while (tmp != p && p.val >= tmp.val) {
                tmp = tmp.next;
                pre = pre.next;
            }
            if (tmp == p) {
                pend = p;
            } else {
                pend.next = p.next;
                p.next = tmp;
                pre.next = p;
            }
            p = pend.next;
        }
        head = pstart.next;
        return head;
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return null;

    }

    public TreeNode reConstructBinaryTree(int[] pre, int prel, int prer, int[] in, int inl, int inr) {
        return null;

    }

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for (int i = 1; i <= sum / 2; i++) {
            ArrayList<Integer> cur = new ArrayList<Integer>();
            int total = 0;
            for (int j = i; total < sum; j++) {
                total += j;
                cur.add(j);
                if (total == sum) {
                    result.add(cur);
                    break;
                }
            }
        }
        return result;
    }

    public ArrayList<String> Permutation(String str) {
        List<String> res = new ArrayList<>();
        if (str != null && str.length() > 0) {
            PermutationHelper(str.toCharArray(), 0, res);
            Collections.sort(res);
        }
        return (ArrayList) res;
    }

    public void PermutationHelper(char[] cs, int i, List<String> list) {
        if (i == cs.length - 1) {
            String val = String.valueOf(cs);
            if (!list.contains(val)) {
                list.add(val);
                System.out.println(val);
            }
        } else {
            for (int j = i; j < cs.length; j++) {
                swap(cs, i, j);
                PermutationHelper(cs, i + 1, list);
                swap(cs, i, j);
            }
        }
    }

    public void swap(char[] cs, int i, int j) {
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }

    /**
     * 30. Substring with Concatenation of All Words
     *
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        int n = s.length();
        int wc = words.length;
        if (n == 0 || wc == 0) {
            return ans;
        }
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < wc; i++) {
            map.put(words[i], 0);
        }
        int wordlen = words[0].length();
        for (int i = 0; i < wordlen; i++) {
            int left = i;
            int count = 0;
            HashMap<String, Integer> tmap = new HashMap<>();
            for (int j = i; j <= n - wordlen; j += wordlen) {
                String str = s.substring(j,j+wordlen);
                if(map.containsKey(str)){
                    tmap.put(str,0);
                    if(tmap.get(str) < map.get(str)){

                    }
                }
            }
        }

        return ans;
    }

    /**
     * 32. Longest Valid Parentheses
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        if (s.equals("")) {
            return 0;
        }
        char[] pars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        stack.push(pars[0]);
        int i = 1;
        int maxvalid = 0;
        int curvalid = 0;
        while (i < pars.length) {
            if (pars[i] == '(') {
                stack.push('(');
                i++;
            } else if (!stack.isEmpty() && stack.pop() == '(') {
                curvalid += 2;
                maxvalid = Math.max(maxvalid, curvalid);
                i++;
            } else {
                curvalid = 0;
                i++;
            }
        }
        return maxvalid;
    }




    /**
     * 94. Binary Tree Inorder Traversal
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> re = new ArrayList<Integer>();
        if (root == null) {
            return re;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null && !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            re.add(cur.data);
            cur = cur.right;
        }
        return re;
    }

    /**
     * 144. Binary Tree Preorder Traversal
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> re = new ArrayList<Integer>();
        if (root == null) {
            return re;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode tmp = stack.pop();
            re.add(tmp.data);
            if (tmp.right != null) {
                stack.push(tmp.right);
            }
            if (tmp.left != null) {
                stack.push(tmp.left);
            }
        }
        return re;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(p);
        TreeNode q = null;
        while (!stack.isEmpty()) {
            while (p.left != null) {
                stack.push(p.left);
                p = p.left;
            }
            while (!stack.isEmpty()) {
                p = stack.pop();
                if (p.right == q || p.right == null) {
                    result.add(p.data);
                    q = p;
                } else {
                    stack.push(p);
                    stack.push(p.right);
                    p = p.right;
                    break;
                }
            }
        }
        return result;
    }

    public void postorderTraversal2(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        stack.push(root);
        TreeNode p;
        while (!stack.isEmpty()) {
            p = stack.pop();
            if (!stack.isEmpty() && stack.peek() == p) {
                if (p.right != null) {
                    stack.push(p.right);
                    stack.push(p.right);
                }
                if (p.left != null) {
                    stack.push(p.left);
                    stack.push(p.left);
                }
            } else {
                System.out.println(p.data);
            }
        }
    }

    /**
     * 101. Symmetric Tree
     *
     * @param root
     * @return
     */
    boolean isSymmetrical2(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.data != t2.data) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }

    boolean isSymmetrical(TreeNode root) {
        if (root == null) {
            return true;
        }
        return comChildren(root.left, root.right);
    }

    boolean comChildren(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        }
        return (left.data == right.data)
                && comChildren(left.left, right.right)
                && comChildren(left.right, right.left);
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        if (pNode.right != null) {
            TreeLinkNode p = pNode.right;
            while (p.left != null) {
                p = p.left;
            }
            return p;
        }
        while (pNode.next != null) {
            TreeLinkNode p = pNode.next;
            if (p.left == pNode) {
                return p;
            } else {
                pNode = pNode.next;
            }
        }
        return null;
    }

    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        int first = 0;
        int last = array.length - 1;
        ArrayList<Integer> result = new ArrayList<>();
        while (first < last) {
            if (array[first] + array[last] == sum) {
                result.clear();
                result.add(array[first]);
                result.add(array[last]);
                first++;
                last--;
            } else if (array[first] + array[last] < sum) {
                first++;
            } else {
                last--;
            }
        }
        return result;
    }

    public int GetNumberOfK(int[] array, int k) {
        int left = GetNumberLeft(array, k, 0, array.length - 1);
        int right = GetNumberRight(array, k, 0, array.length - 1);
        if (right != -1 && right != -1) {
            return (right - left) + 1;
        }
        return 1;
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean children = IsBalanced_Solution(root.left) || IsBalanced_Solution(root.right);
        boolean height = Math.abs(treeheight(root.left) - treeheight(root.right)) < 2;
        return children && height;
    }

    public boolean isNumeric(char[] str) {
        return false;

    }

    public int GetUglyNumber_Solution(int index) {

        if (index < 7) return index;
        ArrayList<Integer> res = new ArrayList<>(index);
        res.add(0, 1);
        int t2 = 0, t3 = 0, t5 = 0, i;
        for (i = 1; i < index; ++i) {
            res.add(i, Math.min(res.get(t2) * 2, Math.min(res.get(t3) * 3, res.get(t5) * 5)));
            if (res.get(i) == res.get(t2) * 2)
                t2++;
            if (res.get(i) == res.get(t3) * 3)
                t3++;
            if (res.get(i) == res.get(t5) * 5)
                t5++;
        }
        return res.get(index - 1);
    }

    //Insert one char from stringstream
    public void Insert(char ch) {
        if (charset.contains(ch)) {
            return;
        }
        if (charlist.contains(ch)) {
            charlist.remove((Character) ch);
            charset.add(ch);
        } else {
            charlist.add(ch);
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        if (charlist.size() >= 1) {
            return charlist.peek();
        }
        return '#';
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode head = new ListNode(-1);
        ListNode p = head;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val + carry;
            carry = val / 10;
            val = val % 10;
            p.next = new ListNode(val);
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int val = l1.val + carry;
            carry = val / 10;
            val = val % 10;
            p.next = new ListNode(val);
            p = p.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int val = l2.val + carry;
            carry = val / 10;
            val = val % 10;
            p.next = new ListNode(val);
            p = p.next;
            l2 = l2.next;
        }
        if (carry > 0) {
            p.next = new ListNode(carry);
        }
        return head.next;
    }

    public int LastRemaining_Solution(int n, int m) {
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            queue.add(i);
        }
        while (queue.size() != 1) {
            for (int i = 0; i < m - 1; i++) {
                queue.add(queue.remove());
            }
            queue.remove();
        }
        return queue.peek();
    }

    public boolean isContinuous(int[] numbers) {
        if (numbers.length != 5) return false;
        int min = 14;
        int max = -1;
        int flag = 0;
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            if (number < 0 || number > 13) return false;
            if (number == 0) continue;
            if (((flag >> number) & 1) == 1)
                return false;
            flag |= (1 << number);
            if (number > max) max = number;
            if (number < min) min = number;
            if (max - min >= 5) return false;
        }
        return true;
    }

    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i : array) {
            if (list.contains(i)) {
                list.remove(new Integer(i));
            } else {
                list.add(i);
            }
        }
        if (list.size() == 2) {
            num1[0] = list.get(0);
            num2[0] = list.get(1);
        }
    }

    public String LeftRotateString(String str, int n) {
        return "";
    }

    public String ReverseSentence(String str) {
        if (str == null || str.trim().equals("")) {
            return str;
        }
        String[] arr = str.split(" ");
        List<String> list = Arrays.asList(arr);
        Collections.reverse(list);
        Iterator<String> it = list.iterator();
        StringBuilder result = new StringBuilder();
        if (!it.hasNext()) {
            return " ";
        }
        for (; ; ) {
            result.append(it.next());
            if (!it.hasNext()) {
                break;
            }
            result.append(" ");
        }
        return result.toString();
    }

    public void Insert(Integer num) {
        if (list.size() == 0 || num < list.getFirst()) {
            list.addFirst(num);
        } else {
            boolean insertFlag = false;
            for (Integer e : list) {
                if (num < e) {
                    int index = list.indexOf(e);
                    list.add(index, num);
                    insertFlag = true;
                    break;
                }
            }
            if (!insertFlag) {
                list.addLast(num);
            }
        }
    }

    public int GetNumberLeft(int[] array, int k, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (right - left) / 2 + left;
        if (array[mid] == k && (mid == 0 || array[mid - 1] < k)) {
            return mid;
        } else if (array[mid] >= k) {
            return GetNumberLeft(array, k, left, mid - 1);
        } else {
            return GetNumberLeft(array, k, mid + 1, right);
        }
    }

    public int GetNumberRight(int[] array, int k, int left, int right) {
        if (left > right) {
            return left;
        }
        int mid = (right - left) / 2 + left;
        if (array[mid] == k && (mid == array.length - 1 || array[mid + 1] > k)) {
            return mid;
        } else if (array[mid] <= k) {
            return GetNumberRight(array, k, mid + 1, right);
        } else {
            return GetNumberRight(array, k, left, mid - 1);
        }

    }


    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int i = 0;
        int j = 0;
        int zi = matrix.length - 1;
        int zj = matrix[0].length - 1;
        for (; i <= zi && j <= zj; i++, j++, zi--, zj--) {
            if (i == zi) {
                for (int k = j; k <= zj; k++) {
                    list.add(matrix[i][k]);
                }
                break;
            }
            if (j == zj) {
                for (int k = i; k <= zi; k++) {
                    list.add(matrix[k][j]);
                }
                break;
            }
            for (int k = j; k <= zj; k++) {
                list.add(matrix[i][k]);
            }
            for (int k = i + 1; k <= zi; k++) {
                list.add(matrix[k][zj]);
            }
            for (int k = zj - 1; k >= j; k--) {
                list.add(matrix[zi][k]);
            }
            for (int k = zi - 1; k > i; k--) {
                list.add(matrix[k][j]);
            }
        }
        return list;
    }




    public int StrToInt(String str) {
        int size = str.length();
        if (size == 0) {
            return 0;
        }
        int s = 1;
        char[] chars = str.toCharArray();
        int res = 0;
        if (chars[0] == '-') {
            s = -1;
        }
        int i = (chars[0] == '-' || chars[0] == '+') ? 1 : 0;
        for (; i < size; i++) {
            if (!(chars[i] < '9' && chars[i] > '0')) {
                return 0;
            }
            res = res * 10 + (chars[i] & 0xf);
        }
        return res * s;
    }

    public String PrintMinNumber(int[] numbers) {
        String str[] = new String[numbers.length];

        Arrays.sort(str, (s1, s2) -> {
            String c1 = s1 + s2;
            String c2 = s2 + s1;
            return 0;
        });
        return "";

    }


    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        int i = 1;
        for (i = 1; i <= n; i *= 10) {
            //i表示当前分析的是哪一个数位
            int a = n / i;
            int b = n % i;
//            count = count + (a + 8) / 10 * i + ((a % 10 == 1) ? 1 : 0) * (b + 1);
            if (a % 10 == 0) {
                count = count + a / 10 * i;
            } else if (a % 10 == 1) {
                count = count + (a / 10 * i) + (b + 1);
            } else {
                count = count + (a / 10 + 1) * i;
            }
        }
        return count;
    }

    public RandomListNode copyRandomList2(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode cur = head;
        while (cur != null) {
            map.put(cur, new RandomListNode(cur.label));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return head;
        }

        RandomListNode copy = head;
        RandomListNode p;
        while (head != null) {
            p = new RandomListNode(head.label);
            p.next = head.next;
            head.next = p;
            head = p.next;
        }

        for (head = copy; head != null; head = head.next) {
            head.next.random = head.random == null ? null : head.random.next;
            head = head.next;
        }

        head = copy;
        copy = head.next;
        while (head != null) {
            p = head.next;
            head.next = p.next;
            if (head.next == null) {
                p.next = null;
            } else {
                p.next = head.next.next;
            }
            head = head.next;
            p = p.next;
        }
        return copy;
    }

    public boolean subwordBreak(String s, Set<String> dict, int first, int last) {
        if (first > last) {
            return false;
        }
        boolean flag = false;
        for (int i = first + 1; i <= last + 1; i++) {
            if (dict.contains(s.substring(first, i))) {
                if (i == last + 1) {
                    return true;
                }
                flag = flag || subwordBreak(s, dict, i, last);
            }
        }
        return flag;
    }

    /**
     * Definition for singly-linked list with a random pointer.
     * class RandomListNode {
     * int label;
     * RandomListNode next, random;
     * RandomListNode(int x) { this.label = x; }
     * };
     */

    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }
}
