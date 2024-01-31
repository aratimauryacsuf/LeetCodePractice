class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        int fresh =0;
        
        for(int i =0;i< m;i++){
            for(int j =0; j<n ;j++){
                if(grid[i][j]==2){
                    queue.offer(new int[] {i,j});
                }
                else if(grid[i][j]==1) fresh+=1;
            }
        }
        
        int count =0;
        
        int[][] dir ={{ 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }};
        while(!queue.isEmpty() && fresh !=0){
            count+=1;
            int size = queue.size();
            for(int i=0;i< size;i++){
                int[] rotten = queue.poll();
                int r = rotten[0];
                int c= rotten[1];
                
                for(int[] d : dir){
                    int x = r+d[0], y = c +d[1];
                    if( x >=0 && x < m && y >=0 && y < n && grid[x][y]==1){
                        grid[x][y] = 2;
                        queue.offer(new int[] {x,y});
                        fresh-=1;
                    }
                }
            }
            
        }
        
        return fresh ==0?count:-1;

    }
}