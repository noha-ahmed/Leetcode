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
        ArrayList<Integer> nums = new ArrayList<>();
        fillNums(root, nums);
        
        int l = 0, r = nums.size() - 1;
        while(l < r){
            int sum = nums.get(r) + nums.get(l);
            if(sum == k) return true;
            if(sum < k) l++;
            else r--;
        }
        
        return false;
    }
    
    private void fillNums(TreeNode root, List<Integer> nums){
        if(root == null) return;
        
        fillNums(root.left, nums);
        nums.add(root.val);
        fillNums(root.right, nums);
    }
}