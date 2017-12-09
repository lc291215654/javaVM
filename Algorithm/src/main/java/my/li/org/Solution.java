package my.li.org;

import my.li.org.binary.ListNode;
import my.li.org.binary.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public static void main(String args[]) {
        int [] a = new int[]{1,3,5,2,4,6};
        reOrderArray(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }



    }
    public static void reOrderArray(int [] array) {
        int i=0;
//        int j=1;
//        int m=array.length-2;
        int k=array.length-1;
        while (i != k && i!=k-1){
            if(isone(array[i]) && istwo(array[i+1])){
                int temp = array[i];
                array[i] =array[i+1];
                array[i+1] = temp;
            }
            i++;
            if(isone(array[k]) && istwo(array[k-1])){
                int temp = array[k];
                array[k] =array[k-1];
                array[k-1] = temp;
            }
            k--;
        }
    }


    static boolean  istwo(int n){
        if((n & 1) ==1){
            return true;
        }
        return false;
    }


    static boolean isone(int n){
        if((n & 1) ==0){
            return true;
        }
        return false;
    }



    public int JumpFloor(int target) {
        int[] arr = new int[target>3?target+1:3];
        arr[0] = 0;
        arr[1] =1;
        arr[2] =2;
        if (target < 3) {
            return arr[target];
        }
        for(int i=3 ;i<=target;i++){
            arr[i] = 2*arr[i-1];
        }
        return arr[target];


    }

    public int Fibonacci(int n) {
        if (n == 1 || n==0) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] arr = new int[n+1];
        arr[1] =  1;
        arr[2] = 2;
        for(int i=3 ;i<=n;i++){
            arr[n] = arr[n-1]+arr[n-2];
        }
        return arr[n];
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
