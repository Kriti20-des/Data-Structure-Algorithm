class Solution {
    public int[][] diagonalSort(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                int key = i - j;

                map.putIfAbsent(key, new ArrayList<>());

                map.get(key).add(mat[i][j]);
            }
        }

        for (ArrayList<Integer> list : map.values()) {

            Collections.sort(list);
        }

        for (int i = m - 1; i >= 0; i--) {

            for (int j = n - 1; j >= 0; j--) {

                int key = i - j;

                mat[i][j] = map.get(key).remove(map.get(key).size() - 1);
            }
        }

        return mat;
    }
}