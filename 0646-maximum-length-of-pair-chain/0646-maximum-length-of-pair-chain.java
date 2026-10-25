class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));

        int n = pairs.length;
        int[][] dp = new int[n + 1][n + 1];

        for (int idx = n - 1; idx >= 0; idx--) {
            for (int prev = idx - 1; prev >= -1; prev--) {

                int skip = dp[idx + 1][prev + 1];

                int take = 0;
                if (prev == -1 ||
                    pairs[prev][1] < pairs[idx][0]) {

                    take = 1 + dp[idx + 1][idx + 1];
                }

                dp[idx][prev + 1] = Math.max(take, skip);
            }
        }

        return dp[0][0];
    }
}
