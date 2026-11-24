class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxProd = nums[0];
        int minProd = nums[0];
        int ans = nums[0];

        for(int i = 1 ; i<n ; i++){

           int tempMax = Math.max(nums[i], Math.max(nums[i] * maxProd, nums[i] * minProd));

            int tempMin = Math.min(nums[i], Math.min(nums[i] * maxProd, nums[i] * minProd));
            
            maxProd = tempMax;
            minProd = tempMin;

            ans = Math.max(ans, maxProd);
        }  
        return ans; 
    }
}