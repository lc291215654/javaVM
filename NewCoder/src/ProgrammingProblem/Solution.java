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

    public static void main(String args[]) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(8);
//        TreeNode node4 = new TreeNode(3);
//        TreeNode node5 = new TreeNode(4);
//        TreeNode node6 = new TreeNode(4);
//        TreeNode node7 = new TreeNode(3);
        node1.right = node2;
        node2.left = node3;
//        node2.left = node4;
//        node2.right = node5;
//        node3.left = node6;
//        node3.right = node7;

        Solution solution = new Solution();
        System.out.println();
        TreeNode root = solution.levMidRestore(new int[]{3,5,4,2,6,7,1},new int[]{2,5,3,6,4,7,1});
        solution.preOrderTraversal(root);
        solution.postorderTraversal(root);

    }

    int find(int[] num,int k){
        for(int i=0;i<num.length;i++){
            if(num[i] == k){
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
        int mi = find(mid,lev[0]);
        helper[mi] = root;
        for(int i = 1; i < lev.length; i++) {
            success = false;
            mi = find(mid,lev[i]);
            helper[mi] = new TreeNode(lev[i]);
            for(int p = mi - 1; p >= 0; p--) {
                if(helper[p] != null) {
                    if(helper[p].right == null) {
                        helper[p].right = helper[mi];
                        success = true;
                    }
                    break;
                }
            }
            if(success) {
                continue;
            }
            for(int p = mi + 1; p < size; p++) {
                if(helper[p] != null) {
                    if(helper[p].left == null) {
                        helper[p].left = helper[mi];
                        success = true;
                    }
                    break;
                }
            }
            if(!success) {
                break;
            }
        }
        return root;
    }


    public boolean match(char[] str, char[] pattern) {
        if(str == null && pattern == null){
            return true;
        }
        if(str != null && pattern == null){
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

    private int index = 0;

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
                if(total == sum){
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
        return  result;
    }

    public void postorderTraversal2(TreeNode root) {
        if(root == null) {
            return ;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        stack.push(root);
        TreeNode p;
        while (!stack.isEmpty()){
            p = stack.pop();
            if(!stack.isEmpty() && stack.peek() == p){
                if(p.right != null){
                    stack.push(p.right);
                    stack.push(p.right);
                }
                if(p.left != null){
                    stack.push(p.left);
                    stack.push(p.left);
                }
            }else {
                System.out.println(p.data);
            }
        }
    }

    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return comChildren(pRoot.left, pRoot.right);
    }

    boolean comChildren(TreeNode leftChildren, TreeNode rightChildren) {
        if (leftChildren == null && rightChildren == null) {
            return true;
        } else if (leftChildren == null || rightChildren == null) {
            return false;
        }
        return (leftChildren.data == rightChildren.data)
                && comChildren(leftChildren.left, rightChildren.right)
                && comChildren(leftChildren.right, rightChildren.left);
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

    private static int treeheight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = treeheight(root.left);
        int right = treeheight(root.right);
        return left > right ? left + 1 : right + 1;
    }

    public boolean isNumeric(char[] str) {
        return false;

    }

    private HashSet<Character> charset = new HashSet<>();
    private LinkedList<Character> charlist = new LinkedList<Character>();

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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null || l2 == null) {
            return null;
        }

        long ll1 = 0;
        long g1 = 1;
        long ll2 = 0;
        long g2 = 1;
        while (l1 != null) {
            ll1 = ll1 + l1.val * g1;
            g1 *= 10;
            l1 = l1.next;
        }

        while (l2 != null) {
            ll2 = ll2 + l2.val * g2;
            g2 *= 10;
            l2 = l2.next;
        }

        long res = ll1 + ll2;
        ListNode head = new ListNode(0);
        if (res == 0) {
            return head;
        }
        ListNode p = head;
        while (res != 0) {
            int k = (int) res % 10;
            ListNode node = new ListNode(k);
            p.next = node;
            p = node;
            res = res / 10;
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


    public boolean wordBreak(String s, Set<String> dict) {
//        return subwordBreak(s, dict, 0, s.length() - 1);
        int len = s.length();
        boolean dp[] = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[len];
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
            }else {
                count = count + (a/10 +1)*i;
            }
        }
        return count;
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
}
