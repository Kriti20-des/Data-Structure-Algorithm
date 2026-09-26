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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> answer = new ArrayList<>();
        if(root == null){
            return answer;
        }
        Queue <TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int flag = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> Level = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                if(flag == 0){
                    Level.add(node.val);
                }
                else{
                    Level.add(0,node.val);
                }
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            answer.add(Level);
            flag = 1-flag;
        }
        return answer;       
    }
}