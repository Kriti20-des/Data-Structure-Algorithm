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
    public int amountOfTime(TreeNode root, int start) {

        Map<TreeNode, TreeNode> parent = new HashMap<>();
        TreeNode startNode = null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        parent.put(root, null);

        while(!queue.isEmpty()){
            TreeNode current = queue.poll();

            if(current.val == start){
                startNode = current;
            }
            if(current.left != null){
                parent.put(current.left, current);
                queue.add(current.left);
            }
            if(current.right != null){
                parent.put(current.right, current);
                queue.add(current.right);
            }

        }
        Set<TreeNode> visited = new HashSet<>();
        queue.add(startNode);
        visited.add(startNode);
        int time = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            boolean burned = false;

            for(int i=0; i<size; i++){
                TreeNode current = queue.poll();

                if(current.left != null && !visited.contains(current.left)){
                    visited.add(current.left);
                    queue.add(current.left);
                    burned = true;
                }
                if(current.right != null && !visited.contains(current.right)){
                    visited.add(current.right);
                    queue.add(current.right);
                    burned = true;
                }
                TreeNode p = parent.get(current);
                if(p != null && !visited.contains(p)){
                    visited.add(p);
                    queue.add(p);
                    burned = true;
                }
            }
            if(burned){
                time++;
            }
        }
        return time;
    }
}