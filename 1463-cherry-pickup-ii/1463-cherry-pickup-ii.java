
class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][][] dp = new int[m][n][n];

        for (int c1 = 0; c1 < n; c1++) {
            for (int c2 = 0; c2 < n; c2++) {

                if (c1 == c2) {
                    dp[m - 1][c1][c2] = grid[m - 1][c1];
                } else {
                    dp[m - 1][c1][c2] =
                        grid[m - 1][c1] + grid[m - 1][c2];
                }
            }
        }

        for (int row = m - 2; row >= 0; row--) {
            for (int c1 = 0; c1 < n; c1++) {
                for (int c2 = 0; c2 < n; c2++) {

                    int maxCherries = 0;

                    for (int d1 = -1; d1 <= 1; d1++) {
                        for (int d2 = -1; d2 <= 1; d2++) {

                            int nc1 = c1 + d1;
                            int nc2 = c2 + d2;

                            if (nc1 >= 0 && nc1 < n &&
                                nc2 >= 0 && nc2 < n) {

                                maxCherries = Math.max(
                                    maxCherries,
                                    dp[row + 1][nc1][nc2]
                                );
                            }
                        }
                    }

                    int cherries = grid[row][c1];

                    if (c1 != c2) {
                        cherries += grid[row][c2];
                    }

                    dp[row][c1][c2] = cherries + maxCherries;
                }
            }
        }

        return dp[0][0][n - 1];
    }
}

