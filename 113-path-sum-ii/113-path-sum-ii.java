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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> paths = new LinkedList<>();
        pathSumRec(root, targetSum, 0, new LinkedList<>(), paths);
        return paths;
    }
    
    private void pathSumRec(TreeNode root, int targetSum, int currentSum, List<Integer> currentPath, List<List<Integer>> paths){
        
        if(root == null) return;
        
        currentSum += root.val;
        currentPath.add(root.val);
        
        if(currentSum == targetSum && root.left == null && root.right == null){
            paths.add(new LinkedList<>(currentPath));
        }
        else{
           pathSumRec(root.left, targetSum, currentSum, currentPath, paths);
           pathSumRec(root.right, targetSum, currentSum, currentPath, paths); 
        }
        
        currentSum -= root.val;
        currentPath.remove(currentPath.size() - 1);
    }

}