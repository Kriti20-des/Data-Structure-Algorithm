class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        
        Set<Integer> set = new HashSet<>();
        long CurrSum = 0;
        long maxSum = 0;

        int left =0;
        for(int right =0; right<nums.length ; right++){
            while(set.contains(nums[right]) || set.size() == k){
                set.remove(nums[left]);
                CurrSum = CurrSum - nums[left];
                left++;
            }
            CurrSum = CurrSum + nums[right];
            set.add(nums[right]);
            if(set.size() == k){
                maxSum = Math.max(CurrSum , maxSum);
            }
        }
        return maxSum;
    }
}