class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(0, nums, new ArrayList<>(), answer);
        return answer;
    }
    private void backtrack(
        int index,
        int[] nums,
        List<Integer> current,
        List<List<Integer>> answer
    ){
        answer.add(new ArrayList<>(current));
        for(int i = index; i<nums.length; i++){
            if(i> index && nums[i]== nums[i-1]){
                continue;
            }
            current.add(nums[i]);
            backtrack(i+1,nums,current, answer);

            current.remove(current.size()-1);
        }
    }
}