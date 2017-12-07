package my.li.org;

import my.li.org.binary.ListNode;
import my.li.org.binary.TreeNode;

import java.util.Stack;

public class Solution {
    public static void main(String args[]) {


    }
    public TreeNode Convert(TreeNode pRootOfTree) {

        if(pRootOfTree==null)
            return null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = pRootOfTree;
        TreeNode pre = null;// 用于保存中序遍历序列的上一节点
        boolean isFirst = true;
        while(p!=null||!stack.isEmpty()){
            while(p!=null){
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if(isFirst){
                pRootOfTree = p;// 将中序遍历序列中的第一个节点记为root
                pre = pRootOfTree;
                isFirst = false;
            }else{
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
                while (p!= null && p.val == val){
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
