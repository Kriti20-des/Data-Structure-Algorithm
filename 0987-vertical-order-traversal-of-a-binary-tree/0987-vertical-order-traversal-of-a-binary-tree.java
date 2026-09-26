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
    public List<List<Integer>> verticalTraversal(TreeNode root) {

        TreeMap<Integer, List<int[]>> map = new TreeMap<>();

        dfs(root, 0, 0, map);

        List<List<Integer>> answer = new ArrayList<>();

        for (List<int[]> list : map.values()) {

            Collections.sort(list, (a, b) -> {

                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                }

                return a[1] - b[1];
            });

            List<Integer> column = new ArrayList<>();

            for (int[] pair : list) {
                column.add(pair[1]);
            }

            answer.add(column);
        }

        return answer;
    }
    void dfs(TreeNode root, int row, int col,
             TreeMap<Integer, List<int[]>> map) {

        if (root == null) {
            return;
        }

        if (!map.containsKey(col)) {
            map.put(col, new ArrayList<>());
        }

        map.get(col).add(new int[]{row, root.val});

        dfs(root.left, row + 1, col - 1, map);

        dfs(root.right, row + 1, col + 1, map);
        
    }
}