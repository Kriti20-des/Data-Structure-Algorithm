class Solution {

    public int rob(int[] nums) {

        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        int case1 = robRange(nums, 1, n - 1);

        int case2 = robRange(nums, 0, n - 2);

        return Math.max(case1, case2);
    }

    public int robRange(int[] nums, int start, int end) {

        int n = end - start + 1;

        if (n == 1) {
            return nums[start];
        }

        int[] dp = new int[n];

        dp[0] = nums[start];

        dp[1] = Math.max(nums[start], nums[start + 1]);

        for (int i = 2; i < n; i++) {

            int currentIndex = start + i;

            int take = nums[currentIndex] + dp[i - 2];

            int skip = dp[i - 1];

            dp[i] = Math.max(take, skip);
        }

        return dp[n - 1];
    }
}