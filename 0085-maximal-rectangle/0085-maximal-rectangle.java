class Solution {
    public int maximalRectangle(char[][] matrix) {
        
        int rows = matrix.length;
        int Cols = matrix[0].length;

        int[] heights = new int [Cols];
        int maxArea = 0;

        for(int i = 0; i<rows ; i++){
            for(int j =0; j<Cols ; j++){

                if(matrix[i][j] == '1'){
                    heights[j]++;
                }else{
                    heights[j] = 0;
                }
            }
            int area = largestRectangleArea(heights);
            maxArea = Math.max(maxArea , area);
        }
        return maxArea;
    }
    public int largestRectangleArea(int[] heights){

        int n = heights.length;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0 ; i<=n ; i++){

            int currentHeight;

            if(i == n){
                currentHeight = 0;
            }else{
                currentHeight = heights[i];
            }
            while(!stack.isEmpty() && heights[stack.peek()] > currentHeight){

                int height = heights[stack.pop()];
                int width;

                if(stack.isEmpty()){
                    width = i;
                }else{
                    width = i-stack.peek()-1;
                }
                int area = height * width;
                maxArea = Math.max(maxArea , area);
            }
            if(i<n){
                stack.push(i);
            }
        }
        return maxArea;
    }
}