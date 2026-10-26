class Solution {
    public int longestStrChain(String[] words) {

       Arrays.sort(words , (a,b) -> Integer.compare(a.length(), b.length()));
       int n = words.length;
       int[][] dp = new int[n][n+1];
       for(int[] row : dp ){
         Arrays.fill(row , -1);
       } 
       return solve(0,-1, words, dp);
    }
    private int solve(int idx, int prev, String[]words, int[][]dp){
        if(idx == words.length){
            return 0;
        }
        if(dp[idx][prev+1] != -1){
            return dp[idx][prev+1];
        }

        int skip = solve(idx+1 , prev, words , dp);

        int take =0;

        if(prev == -1 || isPredecessor(words[prev], words[idx])){
            take = 1 + solve(idx +1,idx, words,dp);
        }
        return dp[idx][prev+1] = Math.max(take , skip);
    }
    private boolean isPredecessor(String shorter , String longer){
        if(longer.length() != shorter.length() +1){
            return false;
        }
        int i =0 , j=0;

        while(i<shorter.length() && j<longer.length()){
            if(shorter.charAt(i) == longer.charAt(j)){
                i++;
            }
            j++;
        }
        return i == shorter.length();
    }
}