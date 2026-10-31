class Solution {
    public void sortColors(int[] nums) {
        ArrayList <Integer> arr = new ArrayList<>();

        int n = nums.length;
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        for(int i =0 ; i<n ; i++){
            if(nums[i] == 0 ){
                count0++;
            }
        }
        for(int i = 0 ; i<n ; i++){
            if(nums[i] == 1){
                count1++;
            }
        }
        for(int i = 0 ; i<n ; i++){
            if(nums[i] == 2){
                 count2++;
            }
        }

        int idx = 0;
        while(count0 > 0) {
            nums[idx] = 0;
            idx++;
            count0--;
        }
        while(count1 > 0) {
            nums[idx] = 1;
            idx++;
            count1--;
        }
        while(count2 > 0) {
            nums[idx] = 2;
            idx++;
            count2--;
        }
        
        
    }
}