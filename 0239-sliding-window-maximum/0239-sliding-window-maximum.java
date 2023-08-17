class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        if (nums == null || k <= 0) {
			return new int[0];
		}
       
       /* 
        int[] result = new int[nums.length - (k-1)];
        
        for(int i =0; i<nums.length -k+1; i++){
             int max = Integer.MIN_VALUE;
            for(int j = i; j< i+k; j++){
                max = Math.max(max, nums[j]);
            }
            result[i] = max;
           
        }
        
        return result;
        */
        
        int n = nums.length;
        int[] res = new int[n -k +1];
        int index = 0;
        
        Deque<Integer> q = new ArrayDeque<>();
        
        for(int i=0; i<n; i++){
            while(!q.isEmpty() && q.peek() < i-k+1){
                q.poll();
            }
            
            while(!q.isEmpty() && nums[q.peekLast()] < nums[i]){
                q.pollLast();
            }
            
            q.offer(i);
            
            if(i>= k-1){
                res[index++] = nums[q.peek()];
            }
        }
        
        
       return res; 
        
        
    }
}