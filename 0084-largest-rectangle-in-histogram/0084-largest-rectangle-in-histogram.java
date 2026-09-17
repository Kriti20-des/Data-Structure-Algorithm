class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int n = heights.length;
        int maxArea = 0 ;

        Stack <Integer> stack = new Stack<>();

        for(int i = 0 ; i<=n; i++){
            int CurrentHeight;
            if(i == n){
                CurrentHeight = 0;
            }else{
                CurrentHeight = heights[i];
            }
            while(!stack.isEmpty() && heights[stack.peek()] > CurrentHeight){

                int height = heights[stack.pop()];
                int width;

                if(stack.isEmpty()){
                    width = i;
                }else{
                    width = i-stack.peek() - 1;
                }

                int area = height*width;
                maxArea = Math.max(maxArea , area);
            }
            if(i<n){
                stack.push(i);
            }
        }
        return maxArea;
    }
}