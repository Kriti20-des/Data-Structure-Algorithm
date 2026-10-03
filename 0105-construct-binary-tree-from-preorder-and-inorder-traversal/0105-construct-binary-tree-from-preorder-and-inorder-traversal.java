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

    int idx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        HashMap<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            mp.put(inorder[i], i);
        }

        return solve(preorder, inorder, 0, inorder.length - 1, mp);
    }

    public TreeNode solve(int[] preorder, int[] inorder, int left, int right, HashMap<Integer, Integer> mp) {

        if (left > right) {
            return null;
        }

        int rootVal = preorder[idx++];

        TreeNode root = new TreeNode(rootVal);

        int mid = mp.get(rootVal);

        root.left = solve(preorder, inorder, left, mid - 1, mp);

        root.right = solve(preorder, inorder, mid + 1, right, mp);

        return root;
    }
}