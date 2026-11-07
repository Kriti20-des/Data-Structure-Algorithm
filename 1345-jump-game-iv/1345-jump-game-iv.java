class Solution {
    public int minJumps(int[] arr) {

        int n = arr.length;

        if (n == 1) {
            return 0;
        }

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }

        boolean[] visited = new boolean[n];

        Queue<Integer> q = new LinkedList<>();

        q.add(0);
        visited[0] = true;

        int steps = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            for (int k = 0; k < size; k++) {

                int index = q.poll();

                if (index == n - 1) {
                    return steps;
                }

                if (index + 1 < n && !visited[index + 1]) {
                    visited[index + 1] = true;
                    q.add(index + 1);
                }

                if (index - 1 >= 0 && !visited[index - 1]) {
                    visited[index - 1] = true;
                    q.add(index - 1);
                }

                if (map.containsKey(arr[index])) {

                    for (int next : map.get(arr[index])) {

                        if (!visited[next]) {
                            visited[next] = true;
                            q.add(next);
                        }
                    }

                    map.remove(arr[index]);
                }
            }

            steps++;
        }

        return -1;
    }
}
