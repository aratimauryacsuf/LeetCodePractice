class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int n = mat1.length;
        int m = mat2[0].length;
        int k = mat1[0].length;
        int[][] ans = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int common =0; common < k; common++){
               if(mat1[i][common] != 0) {
                   for(int j =0; j < m; j++){
                       ans[i][j] += mat1[i][common] * mat2[common][j];
                   }
               }
            }
        }
       return ans; 
    }
}