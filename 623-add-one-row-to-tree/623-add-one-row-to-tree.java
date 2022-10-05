/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if( depth == 1 ){
            TreeNode node = new TreeNode(val, root, null);
            return node;
        }
        addOneRowRec(root, val, depth - 1);
        return root;
    }
    
    private void addOneRowRec(TreeNode root, int val, int depth){
        if(depth == 1){
            TreeNode leftNode = new TreeNode(val, root.left, null);
            TreeNode rightNode = new TreeNode(val, null, root.right);
            root.left = leftNode;
            root.right = rightNode;
        }
        else{
            if(root.left != null) addOneRowRec(root.left, val, depth - 1);
            if(root.right != null) addOneRowRec(root.right, val, depth - 1);
        }
       
    }
}