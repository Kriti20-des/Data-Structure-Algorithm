
class Solution {

    int[][][] dp;
    int m, n;

    public int cherryPickup(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        dp = new int[m][n][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        return solve(0, 0, n - 1, grid);
    }

    int solve(int i, int j1, int j2, int[][] grid) {

        if (j1 < 0 || j1 >= n ||
            j2 < 0 || j2 >= n) {
            return Integer.MIN_VALUE / 2;
        }

        if (dp[i][j1][j2] != -1) {
            return dp[i][j1][j2];
        }

        int cherries = grid[i][j1];

        if (j1 != j2) {
            cherries += grid[i][j2];
        }

        if (i == m - 1) {
            return dp[i][j1][j2] = cherries;
        }

        int maxi = Integer.MIN_VALUE / 2;

        for (int d1 = -1; d1 <= 1; d1++) {
            for (int d2 = -1; d2 <= 1; d2++) {

                int next = solve(
                    i + 1,
                    j1 + d1,
                    j2 + d2,
                    grid
                );

                maxi = Math.max(maxi, next);
            }
        }

        return dp[i][j1][j2] = cherries + maxi;
    }
}
