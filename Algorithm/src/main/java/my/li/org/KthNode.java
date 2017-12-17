package my.li.org;

import my.li.org.binary.TreeNode;

/**
 * Created by LICHENG on 2017/12/17.
 */
public class KthNode {

    int index = 0; //计数器

    TreeNode KthNode(TreeNode root, int k) {
        if (root != null) { //中序遍历寻找第k个
            TreeNode node = KthNode(root.left, k);
            if (node != null)
                return node;
            index++;
            if (index == k)
                return root;
            node = KthNode(root.right, k);
            if (node != null)
                return node;
        }
        return null;
    }
}
