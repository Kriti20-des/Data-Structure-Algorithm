class Solution {
    public int splitArray(int[] nums, int k) {
        
        int low = 0;
        int high = 0;

        for (int i = 0; i < nums.length; i++) {

            low = Math.max(low, nums[i]);
            high = high + nums[i];
        }

        while (low <= high) {

            int mid = (low + high) / 2;

            int parts = 1;
            int sum = 0;

            for (int i = 0; i < nums.length; i++) {

                if (sum + nums[i] <= mid) {
                    sum = sum + nums[i];
                }
                else {
                    parts++;
                    sum = nums[i];
                }
            }

            if (parts <= k) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return low;
    }
}