package my.li.org.binary;

/**
 * Created by licheng on 12/3/17.
 */
public class Balance {

    public boolean isBalance(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            int left = getDeep(root.left);
            int right = getDeep(root.right);
            if (Math.abs(left - right) <= 1) {
                return isBalance(root.left) && isBalance(root.right);
            } else {
                return false;
            }
        }
    }

    public int getDeep(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left = getDeep(root.left);
            int right = getDeep(root.right);
            return left > right ? left + 1 : right + 1;
        }
    }
}
