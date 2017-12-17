package my.li.org;

import my.li.org.binary.ListNode;
import my.li.org.binary.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public static void main(String args[]) {

        int[] sequence = {5, 7, 6, 9, 12, 11, 8};
//        boolean b = VerifySquenceOfBST(sequence);
//        System.out.println(b);


    }






    public int movingCount(int threshold, int rows, int cols) {
        int flag[][] = new int[rows][cols]; //记录是否已经走过
        return helper(0, 0, rows, cols, flag, threshold);
    }

    private int helper(int i, int j, int rows, int cols, int[][] flag, int threshold) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || numSum(i) + numSum(j) >threshold || flag[i][j] == 1){
            return 0;
        }
        flag[i][j] = 1;
        return helper(i - 1, j, rows, cols, flag, threshold)
                + helper(i + 1, j, rows, cols, flag, threshold)
                + helper(i, j - 1, rows, cols, flag, threshold)
                + helper(i, j + 1, rows, cols, flag, threshold)
                + 1;
    }

    private int numSum(int i) {
        int sum = 0;
        do {
            sum += i % 10;
        } while ((i = i / 10) > 0);
        return sum;
    }

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        return isSubtree(root1, root2)
                || HasSubtree(root1.left, root2)
                || HasSubtree(root1.right, root2);
    }

    public static boolean isSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.data == root2.data) {
            return isSubtree(root1.left, root2.left)
                    && isSubtree(root1.right, root2.right);
        } else {
            return false;
        }
    }

    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<Integer>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) return listAll;
        list.add(root.data);
        target -= root.data;
        if (target == 0 && root.left == null && root.right == null)
            listAll.add(new ArrayList<Integer>(list));
        FindPath(root.left, target);
        FindPath(root.right, target);
        list.remove(list.size() - 1);
        return listAll;
    }

    public int MoreThanHalfNum_Solution(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int result = array[0];
        int times = 1; // 次数
        for (int i = 1; i < array.length; ++i) {
            if (times == 0) {
                result = array[i];
                times = 1;
            } else if (array[i] == result) {
                ++times; // 相同则加1
            } else {
                --times; // 不同则减1
            }
        }
        times = 0;
        for (int i = 0; i < array.length; ++i) {
            if (array[i] == result) ++times;
        }
        return (times > array.length / 2) ? result : 0;
    }


    public int JumpFloor(int target) {
        int[] arr = new int[target > 3 ? target + 1 : 3];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        if (target < 3) {
            return arr[target];
        }
        for (int i = 3; i <= target; i++) {
            arr[i] = 2 * arr[i - 1];
        }
        return arr[target];
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    //前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
    private TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn)
            return null;
        TreeNode root = new TreeNode(pre[startPre]);

        for (int i = startIn; i <= endIn; i++)
            if (in[i] == pre[startPre]) {
                root.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                root.right = reConstructBinaryTree(pre, i - startIn + startPre + 1, endPre, in, i + 1, endIn);
            }
        return root;
    }

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (listNode == null) {
            return null;
        }
        ListNode post = null;
        ListNode current = null;
        ListNode pre = null;
        if (listNode.next != null) {
            current = listNode.next;
            post = current.next;
            current.next = null;
        }
        while (post != null) {
            pre = post.next;
            post.next = current;
            current = post;
            post = pre;
        }

        listNode.next = current;
        pre = listNode;
        while (pre != null) {
            result.add(pre.val);
            pre = pre.next;
        }
        return result;

    }


    public boolean Find(int target, int[][] array) {
        if (array.length == 0) {
            return false;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[1].length; j++) {
                if (array[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public TreeNode Convert(TreeNode pRootOfTree) {

        if (pRootOfTree == null)
            return null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = pRootOfTree;
        TreeNode pre = null;// 用于保存中序遍历序列的上一节点
        boolean isFirst = true;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if (isFirst) {
                pRootOfTree = p;// 将中序遍历序列中的第一个节点记为root
                pre = pRootOfTree;
                isFirst = false;
            } else {
                pre.right = p;
                p.left = pre;
                pre = p;
            }
            p = p.right;
        }
        return pRootOfTree;
    }


    public static ListNode deleteDuplication(ListNode pHead) {

        ListNode pre = new ListNode(-1);
        ListNode p = pHead;
        pre.next = p;
        pHead = pre;

        while (p != null && p.next != null) {
            if (p.val == p.next.val) {
                int val = p.val;
                while (p != null && p.val == val) {
                    p = p.next;
                }
                pre.next = p;
            } else {
                pre = p;
                p = p.next;
            }
        }
        return pHead.next;
    }
}
