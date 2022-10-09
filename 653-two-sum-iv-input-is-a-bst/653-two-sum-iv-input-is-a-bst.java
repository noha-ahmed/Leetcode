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
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> nums = new HashSet<>();
        fillNums(root, nums);
        
        if(k%2  == 0 ) nums.remove(k/2);
        for(int num: nums){
            if(nums.contains(k - num)) return true;
        }
        
        return false;
    }
    
    private void fillNums(TreeNode root, Set<Integer> nums){
        if(root == null) return;
        
        fillNums(root.left, nums);
        nums.add(root.val);
        fillNums(root.right, nums);
    }
}