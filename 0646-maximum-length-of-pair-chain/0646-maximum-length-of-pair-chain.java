class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));

        int n = pairs.length;
        int[][] dp = new int[n][n + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, -1, pairs, dp);
    }

    private int solve(int idx, int prev, int[][] pairs, int[][] dp) {
        if (idx == pairs.length) {
            return 0;
        }

        if (dp[idx][prev + 1] != -1) {
            return dp[idx][prev + 1];
        }

        int skip = solve(idx + 1, prev, pairs, dp);

        int take = 0;
        if (prev == -1 || pairs[prev][1] < pairs[idx][0]) {
            take = 1 + solve(idx + 1, idx, pairs, dp);
        }

        return dp[idx][prev + 1] = Math.max(take, skip);
    }
}
