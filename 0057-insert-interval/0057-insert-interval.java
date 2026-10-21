class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> res = new ArrayList<>();
        if(intervals.length<=0){
            res.add(newInterval);
            return res.toArray( new int[res.size()][]);
        }
        boolean isUsed= false;
        for(int []interval : intervals ){
     
            if(!isUsed && interval[0]>newInterval[1]){
                res.add(newInterval);
                res.add(interval);
                isUsed =true;                
            } else if(!isUsed && interval[1]>=newInterval[0]){ 
                newInterval[0] = Math.min(interval[0],newInterval[0]);
                newInterval[1] = Math.max(interval[1],newInterval[1]);
            }else{
                res.add(interval);
            }
        }
        
        if(!isUsed){
            res.add(newInterval);

        }
        return res.toArray( new int[res.size()][]);
        
    }
}