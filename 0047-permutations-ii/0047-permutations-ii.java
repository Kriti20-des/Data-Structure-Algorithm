class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        List<List<Integer>> answer = new ArrayList<>();

        Arrays.sort(nums);

        boolean[] used = new boolean[nums.length];

        backtrack(nums, used, new ArrayList<>(), answer);

        return answer;
    }

    private void backtrack(
        int[] nums,
        boolean[] used,
        List<Integer> current,
        List<List<Integer>> answer
    ) {

        if (current.size() == nums.length) {
            answer.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (used[i]) {
                continue;
            }

            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            current.add(nums[i]);
            used[i] = true;

            backtrack(nums, used, current, answer);

            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}