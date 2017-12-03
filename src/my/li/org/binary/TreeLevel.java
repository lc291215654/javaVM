package my.li.org.binary;

/**
 * Created by licheng on 12/3/17.
 */
public class TreeLevel {
    ListNode listNode = new ListNode(-1);
    ListNode p = listNode;
    public ListNode getTreeLevel(TreeNode root,int dep){
        if(root==null || dep == 0){
            return null;
        }
        if (dep == 1){
            p.next = new ListNode(root.data);
            p = p.next;
        }else {
            getTreeLevel(root.left,dep-1);
            getTreeLevel(root.right,dep -1);
        }
        return listNode.next;
    }
}
