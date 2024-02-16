class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i< arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));
        for(int key : map.keySet()){
            pq.offer(key);
        }
    
        while(k >0 && !pq.isEmpty()){
            k = k - map.get(pq.poll());
        }
        
        return k<0? pq.size()+1: pq.size();
        
        
    }
}