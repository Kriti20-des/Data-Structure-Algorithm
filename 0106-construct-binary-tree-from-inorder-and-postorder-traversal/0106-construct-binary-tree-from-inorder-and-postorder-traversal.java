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
    int idx;

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        idx = postorder.length - 1;

        HashMap<Integer, Integer> mp = new HashMap<>();

        for(int i = 0; i < inorder.length; i++){
            mp.put(inorder[i], i);
        }

        return solve(inorder, postorder, 0, inorder.length - 1, mp);
    }

    public TreeNode solve(int[] inorder, int[] postorder, int left, int right, HashMap<Integer, Integer> mp) {

        if(left > right){
            return null;
        }

        int rootval = postorder[idx--];

        TreeNode root = new TreeNode(rootval);

        int mid = mp.get(rootval);

        root.right = solve(inorder, postorder, mid + 1, right, mp);

        root.left = solve(inorder, postorder, left, mid - 1, mp);

        return root;
    }
}