class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(candidates);

        backtrack(0, candidates, target, new ArrayList<>(), answer);
        return answer;
    }
    private void backtrack(
        int index, int[] candidates,
        int target,
        List<Integer> current ,
        List<List<Integer>> answer
    ){
        if(target==0){
            answer.add(new ArrayList<>(current));
            return;
        }
        for(int i = index; i< candidates.length; i++){
            if(i> index && candidates[i] == candidates[i-1]){
                continue;
            }
            if(candidates[i] > target){
                break;
            }
            current.add(candidates[i]);
            backtrack(
                i+1, candidates, target-candidates[i],
                current , answer
            );
            current.remove(current.size()-1);
        }
    }
}