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
    int cams = 0;
    HashSet<TreeNode> covered;
    public int minCameraCover(TreeNode root) {
        covered = new HashSet<>();
        covered.add(null);
        cover(root, null);
        return cams;
    }
    
    public void cover(TreeNode node, TreeNode parent){
        if( node != null ){
            cover(node.left, node);
            cover(node.right, node);
            if( (parent == null && !covered.contains(node) )
                || !covered.contains(node.left) || !covered.contains(node.right) ){
                cams++;
                covered.add(node);
                covered.add(parent);
                covered.add(node.left);
                covered.add(node.right);
            }
        }
    }
}