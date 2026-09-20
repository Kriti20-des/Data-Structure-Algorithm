class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> answer = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), answer);

        return answer;
    }

    private void backtrack(
        int index,
        int[] nums,
        List<Integer> current,
        List<List<Integer>> answer
    ){
        
        if(index==nums.length){
            answer.add(new ArrayList<> (current));
            return;
        }
        current.add(nums[index]);

        backtrack(index+1, nums, current, answer);

        current.remove(current.size() - 1);

        backtrack(index+1, nums, current, answer);
    }
}