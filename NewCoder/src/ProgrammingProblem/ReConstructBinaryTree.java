package ProgrammingProblem;

import my.li.org.binary.TreeNode;

import java.io.IOException;

/**
 * Created by licheng on 5/22/18.
 */
public class ReConstructBinaryTree {

    public TreeNode reConstructBinaryTree(int[] pre,int[] in){
        return reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
    }

    public TreeNode reConstructBinaryTree(int[] pre,int preStart,int preEnd,int[] in,int inStart,int inEnd){
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);
        for(int i= inStart;i<=inEnd;i++){
            if(in[i] == pre[preStart]){
                root.left = reConstructBinaryTree(pre,preStart+1,preStart+(i-inStart),in,inStart,i-1);
                root.right= reConstructBinaryTree(pre,preStart+(i-inStart)+1,preEnd,in,i+1,inEnd);
                break;
            }
        }
        return root;
    }

    public static void main(String args[]){
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        ReConstructBinaryTree re = new ReConstructBinaryTree();
        TreeNode root = re.reConstructBinaryTree(pre,in);

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
