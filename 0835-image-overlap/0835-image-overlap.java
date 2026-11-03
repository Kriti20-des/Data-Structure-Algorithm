
class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {

        int n = img1.length;
        int ans = 0;

        for (int rowOff = -n + 1; rowOff < n; rowOff++) {

            for (int colOff = -n + 1; colOff < n; colOff++) {

                int count = 0;

                for (int i = 0; i < n; i++) {

                    for (int j = 0; j < n; j++) {

                        int r = i + rowOff;
                        int c = j + colOff;

                        if (r >= 0 && r < n &&
                            c >= 0 && c < n &&
                            img1[i][j] == 1 &&
                            img2[r][c] == 1) {

                            count++;
                        }
                    }
                }

                ans = Math.max(ans, count);
            }
        }

        return ans;
    }
}
