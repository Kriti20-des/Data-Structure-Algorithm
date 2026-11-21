class Solution {
    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;
        boolean[] visited = new boolean[n];

        int provinces = 0;

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                provinces++;

                Queue<Integer> queue = new LinkedList<>();

                queue.offer(i);
                visited[i] = true;

                while (!queue.isEmpty()) {

                    int node = queue.poll();

                    for (int j = 0; j < n; j++) {

                        if (isConnected[node][j] == 1 && !visited[j]) {

                            visited[j] = true;
                            queue.offer(j);
                        }
                    }
                }
            }
        }

        return provinces;
    }
}