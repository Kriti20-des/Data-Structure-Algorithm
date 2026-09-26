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

    int maxSum;
    int solve(TreeNode root){
        if(root == null){
            return 0;
        }
        int L = solve(root.left);
        int R = solve(root.right);

        int down_answer = L + R + root.val;
        int only_one_good = Math.max(L,R) + root.val;
        int only_root = root.val;

        maxSum = Math.max(maxSum, down_answer);
        maxSum = Math.max(maxSum, only_one_good);
        maxSum = Math.max(maxSum, only_root);

        return Math.max(only_one_good , only_root);
    }

    public int maxPathSum(TreeNode root) {

        maxSum = Integer.MIN_VALUE;
        solve(root);
        return maxSum;
    }
}