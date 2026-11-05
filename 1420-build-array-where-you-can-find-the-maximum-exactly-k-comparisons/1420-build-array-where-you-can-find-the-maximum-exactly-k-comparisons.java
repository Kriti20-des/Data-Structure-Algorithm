class Solution {
    public int numOfArrays(int n, int m, int k) {

        int MOD = 1000000007;

        long[][][] dp = new long[n + 1][m + 1][k + 1];

        for (int j = 1; j <= m; j++) {
            dp[1][j][1] = 1;
        }

        for (int len = 1; len < n; len++) {

            for (int maxVal = 1; maxVal <= m; maxVal++) {

                for (int cost = 1; cost <= k; cost++) {

                    if (dp[len][maxVal][cost] == 0) {
                        continue;
                    }

                    dp[len + 1][maxVal][cost] = (dp[len + 1][maxVal][cost] + dp[len][maxVal][cost] * maxVal) % MOD;

                    for (int x = maxVal + 1; x <= m; x++) {

                        if (cost + 1 <= k) {

                            dp[len + 1][x][cost + 1] = (dp[len + 1][x][cost + 1] + dp[len][maxVal][cost]) % MOD;
                        }
                    }
                }
            }
        }

        long ans = 0;

        for (int maxVal = 1; maxVal <= m; maxVal++) {
            ans = (ans + dp[n][maxVal][k]) % MOD;
        }

        return (int) ans;
    }
}