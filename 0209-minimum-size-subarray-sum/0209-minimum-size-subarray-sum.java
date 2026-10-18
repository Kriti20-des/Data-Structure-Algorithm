class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int minLen = Integer.MAX_VALUE;
        int left = 0;
        int CurrSum = 0;

        for(int right = 0 ; right<nums.length; right++){
            CurrSum = CurrSum + nums[right];
            while(CurrSum >= target){
                if(right-left+1 < minLen){
                    minLen = right-left+1;
                }
                CurrSum = CurrSum- nums[left];
                left++;
            }
        }
        return minLen != Integer.MAX_VALUE ? minLen : 0;
    }
}