class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        HashMap<Integer , Integer> map = new HashMap<>();
        
        for(int i =0 ; i<n ; i++){
            for(int j =0 ; j<n ; j++){
                int num = grid[i][j];
                map.put(num, map.getOrDefault(num,0) +1);
           }
        }
        int repeated = 0;
        int missing = 0;
        for(int num = 1; num<= n*n ; num++){
            int freq = map.getOrDefault(num ,0);

            if(freq == 2){
                repeated = num;
            }
            if(freq == 0){
                missing = num;
            }
        }
        return new int[]{repeated , missing};
    }
}