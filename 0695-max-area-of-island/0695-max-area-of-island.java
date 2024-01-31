class Solution {
    private int maxArea=0;
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        
        for(int i=0;i<row;i++){
            for(int j =0;j<col; j++){
                maxArea = Math.max(maxArea, area(grid, i,j));
            }
        }
        
        return maxArea;
    }
    
    public int area(int[][] grid, int i, int j ){
        int area =0;
        if(i>=0 &&  j>=0 && i< grid.length && j< grid[0].length && grid[i][j] == 1){
            grid[i][j] = 0;
            area = 1+ area(grid, i-1,j) +area(grid, i,j-1)+area(grid, i+1,j)+area(grid, i,j+1);
        }
        return area;
    }
}