class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxCount = Integer.MIN_VALUE;
        
        for(int i : nums){
            map.put(i, map.getOrDefault(i,0)+1);
            
            maxCount = Math.max(maxCount, map.get(i));
        }
        int count =0;
        for(int key : map.keySet()){
            if(map.get(key) == maxCount){
                count+=map.get(key);
            }
        }
        
        
        return count;
        
    }
}