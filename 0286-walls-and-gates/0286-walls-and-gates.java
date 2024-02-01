class Solution {
    private static final int EMPTY = Integer.MAX_VALUE;
    public void wallsAndGates(int[][] rooms) {
        
        int rows = rooms.length;
        int cols = rooms[0].length;

        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i< rows; i++){
            for(int j=0; j<cols; j++){
                if(rooms[i][j] == 0){
                    queue.add(new int[] {i,j});
                }
            }
        }

        int[][] dirs = {{ -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

        while(!queue.isEmpty()){
            int[] point = queue.poll();
            int row = point[0];
            int col = point[1];
            for(int[] dir: dirs){
                int r = row + dir[0];
                int c = col + dir[1];

                if( r <0 || c<0 ||r >= rows || c>= cols || rooms[r][c] != EMPTY )
                    continue;
                
                rooms[r][c] = rooms[row][col]+1;
                queue.add(new int[] {r,c});
            }
        }
    }
}