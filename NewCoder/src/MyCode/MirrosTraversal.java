package MyCode;

import my.li.org.binary.TreeNode;

/**
 * Created by LICHENG on 2018/8/29.
 * 牛客网基础班第三季第十一节课
 */
public class MirrosTraversal {
    public static void main(String[] args){
        TreeNode head = new TreeNode(4);
        head.left = new TreeNode(2);
        head.right = new TreeNode(6);
        head.left.left = new TreeNode(1);
        head.left.right = new TreeNode(3);
        head.right.left = new TreeNode(5);
        head.right.right = new TreeNode(7);

        MirrosTraversal traversal = new MirrosTraversal();
        traversal.mirrosTraversal(head);
    }
    public void mirrosTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode cur = root;
        TreeNode p;
        while (cur != null) {
            System.out.println(cur.data + " f");
            if (cur.left != null) {
                p = cur.left;
                while (p.right != null && p.right != cur) {
                    p = p.right;
                }
                if(p.right == cur){
                    p.right = null;
                    printRight(cur.left);
                    cur = cur.right;
                }else {
                    p.right = cur;
                    cur = cur.left;
                }
            } else {
                cur = cur.right;
            }
        }
    }

    private void printRight(TreeNode left) {
        while (left != null){
            System.out.println();
        }
    }

}
