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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPathSumRec(root, targetSum, 0);
    }
    
    private boolean hasPathSumRec(TreeNode root, int targetSum, int currentSum){
        if(root == null) return false;
        
        currentSum += root.val;
        
        if(currentSum == targetSum && root.left == null && root.right == null)
            return true;
        
        boolean pathFound = hasPathSumRec(root.left, targetSum, currentSum);
        if(pathFound) return true;
        
        pathFound = hasPathSumRec(root.right, targetSum, currentSum);
        if(pathFound) return true;
        
        currentSum -= root.val;
        return false;
    }
}