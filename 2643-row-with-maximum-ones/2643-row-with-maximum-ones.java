class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        
        int maxOnes = 0;
        int answerRow = 0;

        for (int i = 0; i < mat.length; i++) {

            int count = 0;

            for (int j = 0; j < mat[i].length; j++) {

                if (mat[i][j] == 1) {
                    count++;
                }
            }

            if (count > maxOnes) {
                maxOnes = count;
                answerRow = i;
            }
        }

        return new int[]{answerRow, maxOnes};
    }
}