class Solution {
    public int minSetSize(int[] arr) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i : arr){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        if(map.size() == 1) return 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        
        for(int n: map.keySet()){
            pq.offer(map.get(n));
        }
        
        
        int count = 0; 
        int sum=0 ;
        while(!pq.isEmpty()){
            sum += pq.poll();
            count++;
            if(sum >= arr.length/2) return count;
        }
        
        return 1;
    }
}