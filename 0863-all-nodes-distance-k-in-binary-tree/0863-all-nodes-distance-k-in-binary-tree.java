/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void markParents(TreeNode root, Map<TreeNode, TreeNode> parentMap){

        Queue <TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left != null){
                parentMap.put(node.left, node);
                queue.add(node.left);
            }
            if(node.right != null){
                parentMap.put(node.right, node);
                queue.add(node.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        markParents(root, parentMap);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);

        Set<TreeNode> visited = new HashSet<>();
        visited.add(target);

        int distance= 0;
        while(!queue.isEmpty()){

            if(distance == k){
                break;
            }
            int size = queue.size();
            for(int i =0; i<size; i++){
                TreeNode node = queue.poll();

                if(node.left != null && !visited.contains(node.left)){
                    visited.add(node.left);
                    queue.add(node.left);
                }
                if(node.right != null && !visited.contains(node.right)){
                    visited.add(node.right);
                    queue.add(node.right);
                }
                if(parentMap.containsKey(node) && !visited.contains(parentMap.get(node))){

                    visited.add(parentMap.get(node));
                    queue.add(parentMap.get(node));
                }    
            }
            distance ++;
        }
        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()){
            result.add(queue.poll().val);
        }
        return result;
    }
}