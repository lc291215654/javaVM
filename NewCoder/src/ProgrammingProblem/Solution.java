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
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public static void main(String args[]) {
        Solution solution = new Solution();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(7);
        ListNode node5 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        System.out.println(solution.sortList(node1));

        while(node1!= null){
            System.out.println(node1.val);
            node1 = node1.next;
        }

    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode p = head.next;
        ListNode pstart = new ListNode(0);
        ListNode pend = head;
        pstart.next = head;
        while (p != null){
            ListNode tmp = pstart.next;
            ListNode pre = pstart;
            while (tmp != p && p.val >= tmp.val){
                tmp = tmp.next;
                pre = pre.next;
            }
            if(tmp == p){
                pend = p;
            } else
            {
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


    public int GetNumberOfK(int[] array, int k) {
        int left = GetNumberLeft(array, k, 0, array.length - 1);
        int right = GetNumberRight(array, k, 0, array.length - 1);
        if (right != -1 && right != -1) {
            return (right - left) + 1;
        }
        return 0;
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

    public String PrintMinNumber(int [] numbers) {
        String str[] = new String[numbers.length];

        Arrays.sort(str, (s1, s2) -> {
            String c1 = s1 + s2;
            String c2 = s2 + s1;
            return 0;
        });
        return "";

    }

    public boolean duplicate(int numbers[],int length,int [] duplication) {


        return false;
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
