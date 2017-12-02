package my.li.org.binary;

import java.util.Stack;
import java.util.Vector;

/**
 * Created by licheng on 11/30/17.
 */
public class NodeQuery {
    public static void preOrder(TreeNode root) {
        if (root != null) {
            System.out.print(root.data + "--");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + "--");
            inOrder(root.right);
        }
    }

    public static void postOrder(TreeNode root) {

        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + "--");
        }
    }

    public static void  nonRecursionOrder(TreeNode root){
        Stack<TreeNode> sta = new Stack<TreeNode>();
        TreeNode p;
        if(root !=null ){
            sta.push(root);
            sta.push(root);
            while (!sta.isEmpty()){
                p= sta.pop();
                if(!sta.isEmpty() && p == sta.peek()){
                    if(p.right != null){
                        sta.push(p.right);
                        sta.push(p.right);
                    }
                    if(p.left != null){
                        sta.push(p.left);
                        sta.push(p.left);
                    }
                }else {
                    System.out.print(p.data + "--");
                }

            }

        }

    }

    public static void main(String[] args) {

        int[] array = {35, 17, 39, 9, 28, 65, 56, 87};
        TreeNode root = new TreeNode(array[0]);   //创建二叉树
        for (int i = 1; i < array.length; i++) {
            root.insert(root, array[i]);       //向二叉树中插入数据
        }
        System.out.println("preOrder：");
        preOrder(root);
        System.out.println();

        System.out.println("inOrder：");
        inOrder(root);
        System.out.println();

        System.out.println("postOrder：");
        postOrder(root);
        System.out.println();

        System.out.println("nonRecursionOrder：");
        nonRecursionOrder(root);
        System.out.println();

        boolean exist = root.findKey(root,9);

        System.out.println(exist);
    }


}
