class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
       // Set<Integer> set = new HashSet<>();
        
        //Bellmonford
        
        int[] path = new int[n];
        
        Arrays.fill(path, Integer.MAX_VALUE);
        
        path[k-1]=0;
        
        for(int i=0; i<n; i++){
            for(int j=0;j<times.length;j++){
                int src = times[j][0];
                int tgt = times[j][1];
                int time = times[j][2];
                
                if(path[src-1] != Integer.MAX_VALUE && path[src-1]+time < path[tgt-1]){
                    path[tgt-1]=path[src-1] + time;
                }
            }
        }
        
        int result = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            if(path[i] == Integer.MAX_VALUE){
                return -1;
            }
            
            result = Math.max(result, path[i]);
            
        }
        
        return result;
    }
}