class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int count =0;
        for(int i = 0; i< row; i++){
            for(int j = 0; j< col; j++){
                if(grid[i][j] == '1'){
                    dfsFill(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    
    public void dfsFill( char[][] grid,int i, int j){
        if(i>=0 && j>=0 && i<grid.length && j<grid[0].length && grid[i][j] =='1'){
        grid[i][j]='0';

        dfsFill(grid, i + 1, j);
        dfsFill(grid, i - 1, j);
        dfsFill(grid, i, j + 1);
        dfsFill(grid, i, j - 1);

    }
    }
}