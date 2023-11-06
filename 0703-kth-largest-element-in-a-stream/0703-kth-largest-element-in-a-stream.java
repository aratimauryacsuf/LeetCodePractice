class KthLargest {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    int k;
    
    public KthLargest(int k, int[] nums) {
        this.k =k;
        for(int n : nums){
            add(n);
        }
    }
    
    public int add(int val) {
        if(minHeap.size() < k){
            minHeap.offer(val);
        }else if(val > minHeap.peek()){
            minHeap.poll();
            minHeap.offer(val);
        }
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */

