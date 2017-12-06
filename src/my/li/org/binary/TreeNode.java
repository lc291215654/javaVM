package my.li.org.binary;

/**
 * Created by licheng on 11/30/17.
 */
public class TreeNode {
    public int data;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
        super();
    }

    public TreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    public void insert(TreeNode root, int data) {
        if (data > root.data) {
            if (root.right == null) {
                root.right = new TreeNode(data);
            } else {
                this.insert(root.right, data);
            }
        } else if(data < root.data){
            if (root.left == null) {
                root.left = new TreeNode(data);
            } else {
                this.insert(root.left, data);
            }
        } else{
            System.out.print(data + "have exist!");
        }

    }

    public boolean findKey(TreeNode root, int data) {
        TreeNode p = root;
        while (p != null) {
            if(p.data == data){
                return true;
            }else if(p.data < data){
                p = p.right;
            }else {
                p= p.left;
            }
        }

        return false;
    }
}
