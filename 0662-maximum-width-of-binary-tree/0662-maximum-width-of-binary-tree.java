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
    public int widthOfBinaryTree(TreeNode root) {
        
        if(root == null){
            return 0;
        }
        Queue<Pair<TreeNode, Long>> queue = new LinkedList<>();
        queue.add(new Pair<>(root,0L));
        long maxWidth = 0;

        while(!queue.isEmpty()){
            int size = queue.size();

            long firstIndex = 0;
            long lastIndex = 0;
            for(int i =0; i<size; i++){
                Pair<TreeNode ,Long> current = queue.poll();

                TreeNode node = current.getKey();
                Long index = current.getValue();
                
                if(i==0){
                    firstIndex = index;
                }
                if(i == size-1){
                    lastIndex = index;
                }
                if(node.left != null){
                    queue.add(new Pair<>(node.left, 2*index +1));
                }
                if(node.right != null){
                    queue.add(new Pair<>(node.right, 2*index+2));
                }
            }
            Long width = lastIndex - firstIndex +1;
            maxWidth = Math.max(maxWidth , width);
        }
        return (int) maxWidth;
    }
}