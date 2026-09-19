class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();

        Arrays.sort(candidates);

        solve(0, candidates, target, new ArrayList<>(), answer);

        return answer;
    }

    private void solve(
        int index,
        int[] candidates,
        int target,
        List<Integer> current,
        List<List<Integer>> answer
    ) {

        if (target == 0) {
            answer.add(new ArrayList<>(current));
            return;
        }

        if (index == candidates.length) {
            return;
        }

        if (candidates[index] > target) {
            return;
        }

        current.add(candidates[index]);

        solve(
            index,
            candidates,
            target - candidates[index],
            current,
            answer
        );

        current.remove(current.size() - 1);

        solve(
            index + 1,
            candidates,
            target,
            current,
            answer
        );
    }
}