package ProgrammingProblem;

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

public class Solution {
    LinkedList<Integer> list = new LinkedList<Integer>();

    public static void main(String args[]) {
        Solution solution = new Solution();
        ListNode head1 = new ListNode(2);
        ListNode node11 = new ListNode(2);
        ListNode node12 = new ListNode(2);
        head1.next = node11;
        node11.next = node12;

        ListNode head2 = new ListNode(3);
        ListNode node21 = new ListNode(4);
        ListNode node22 = new ListNode(5);
        head2.next = node21;
        node21.next = node22;

        ListNode head3 = solution.addTwoNumbers(head1,head2);

        System.out.println(head3.val);
        System.out.println(head3.next.val);
        System.out.println(head3.next.next.val);


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

        if (l1 == null || l2 == null){
            return null;
        }

        long ll1 = 0;
        long g1 = 1;
        long ll2 = 0;
        long g2 = 1;
        while (l1!= null){
            ll1 = ll1 + l1.val * g1;
            g1 *= 10;
            l1 = l1.next;
        }

        while (l2!= null){
            ll2 = ll2 + l2.val * g2;
            g2 *= 10;
            l2 = l2.next;
        }

        long res = ll1 + ll2;
        ListNode head = new ListNode(0);
        if(res == 0){
            return head;
        }
        ListNode p = head;
        while(res != 0){
            int k = (int)res % 10;
            ListNode node = new ListNode(k);
            p.next = node;
            p = node;
            res = res/10;
        }
        return head.next;
    }

    public int LastRemaining_Solution(int n, int m) {
        return 0;

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

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str != null && str.length() > 0) {
            PermutationHelper(str.toCharArray(), 0, res);
            Collections.sort(res);
        }
        return res;
    }

    public void PermutationHelper(char[] cs, int i, List<String> list) {
        if (i == cs.length - 1) {
            String val = String.valueOf(cs);
            if (!list.contains(val))
                list.add(val);
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

    public Double GetMedian() {
        if (list.size() == 0) {
            return null;
        }

        if (list.size() % 2 == 0) {
            int i = list.size() / 2;
            Double a = Double.valueOf(list.get(i - 1) + list.get(i));
            return a / 2;
        }
        list.get(0);
        Double b = Double.valueOf(list.get((list.size() + 1) / 2 - 1));
        return Double.valueOf(list.get((list.size() + 1) / 2 - 1));

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
