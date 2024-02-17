class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
     
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i =0; i< heights.length-1;i++){
            
            int hdiff = heights[i+1] - heights[i];
            if(hdiff >0){ 
                pq.offer(hdiff);
                
                if(pq.size()>ladders){
                    if(bricks >= pq.peek()){
                     bricks = bricks - pq.poll();
                 } else return i;   
                }
            }
        }
        
       return heights.length-1;
        
    }
}