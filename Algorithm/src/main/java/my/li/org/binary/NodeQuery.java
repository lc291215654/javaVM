package my.li.org.binary;

import java.util.Stack;

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

    /**
     * 非递归前序遍历
     *
     * @param root
     */
    public static void nonRecursionPreOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                System.out.print(p.data + "--");
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            p = p.right;
        }
    }


    /**
     * 非递归后序遍历
     *
     * @param root
     */
    public static void nonRecursionPostOrder(TreeNode root) {
        Stack<TreeNode> sta = new Stack<TreeNode>();
        TreeNode p;
        if (root != null) {
            sta.push(root);
            sta.push(root);
            while (!sta.isEmpty()) {
                p = sta.pop();
                if (!sta.isEmpty() && p == sta.peek()) {
                    if (p.right != null) {
                        sta.push(p.right);
                        sta.push(p.right);
                    }
                    if (p.left != null) {
                        sta.push(p.left);
                        sta.push(p.left);
                    }
                } else {
                    System.out.print(p.data + "--");
                }

            }

        }

    }

    /**
     * 非递归后序遍历2
     */
    static void PostOrderWithoutRecursion(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur, lastVisit = null;
        cur = root;
        //先把cur移动到左子树最下边
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        while (!stack.empty()) {
            //走到这里，cur都是空，并已经遍历到左子树底端(看成扩充二叉树，则空，亦是某棵树的左孩子)
            cur = stack.pop();
            //一个根节点被访问的前提是：无右子树或右子树已被访问过
            if (cur.right == null || cur.right == lastVisit) {
                System.out.print(cur.data + "--");
                //修改最近被访问的节点
                lastVisit = cur;
            } else {
                //根节点再次入栈
                stack.push(cur);
                //进入右子树，且可肯定右子树一定不为空
                cur = cur.right;
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
            }
        }
    }

    /**
     * 非递归中序遍历
     *
     * @param root
     */
    public static void nonRecursionInOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            System.out.print(p.data + "--");
            p = p.right;
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

        System.out.println("nonRecursionPreOrder：");
        nonRecursionPreOrder(root);
        System.out.println();


        System.out.println("nonRecursionInOrder：");
        nonRecursionInOrder(root);
        System.out.println();

        System.out.println("nonRecursionPostOrder：");
        PostOrderWithoutRecursion(root);
        System.out.println();

        boolean exist = root.findKey(root, 9);

        System.out.println(exist);
    }


}
