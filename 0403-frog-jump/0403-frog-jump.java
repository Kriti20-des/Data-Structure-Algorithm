class Solution {

    Map<Integer, Integer> map = new HashMap<>();
    Boolean[][] dp;

    boolean solve(int[] stones, int index, int jump) {

        if (index == stones.length - 1) {
            return true;
        }

        if (dp[index][jump] != null) {
            return dp[index][jump];
        }

        for (int nextJump = jump - 1; nextJump <= jump + 1; nextJump++) {

            if (nextJump <= 0) {
                continue;
            }

            int nextPosition = stones[index] + nextJump;

            if (map.containsKey(nextPosition)) {

                int nextIndex = map.get(nextPosition);

                if (solve(stones, nextIndex, nextJump)) {
                    return dp[index][jump] = true;
                }
            }
        }

        return dp[index][jump] = false;
    }

    public boolean canCross(int[] stones) {

        if (stones[1] != 1) {
            return false;
        }

        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], i);
        }

        dp = new Boolean[stones.length][stones.length + 1];

        return solve(stones, 0, 0);
    }
}