class Solution {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] -b[0]);
        Set<Integer> visited = new HashSet<>();
        int cost = 0;
        int length = points.length;
        
        pq.offer(new int[]{0,0});
        
        while(visited.size() < length){
            int[] arr  = pq.poll();
            
            int weight = arr[0];
            int curNode  = arr[1];
            
            if(visited.contains(curNode)) continue;
            
            visited.add(curNode);
            cost = cost + weight;
            
            for(int nextNode=0; nextNode < length; nextNode++){
                if(!visited.contains(nextNode)){
                    int nextWeight = Math.abs(points[nextNode][0] -points[curNode][0])+ Math.abs(points[nextNode][1] -points[curNode][1]);
                    pq.offer(new int[] {nextWeight, nextNode});
                }
            }
        }
        
        
        return cost;
    }
}