class Solution {
    
    public int lastStoneWeight(int[] stones) {
        //int n = stones.length ;
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder())  ;
        
        for(int n: stones)
            maxHeap.add(n);   
        
        while(maxHeap.size() >1){
        maxHeap.add(maxHeap.poll() - maxHeap.poll());
        }
        
        return maxHeap.peek();
        }
    
   
    
    
}