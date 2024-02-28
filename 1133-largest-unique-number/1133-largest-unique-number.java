class Solution {
    public int largestUniqueNumber(int[] nums) {
        if(nums.length == 0) return -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        int max =0;
        for(int i =0; i < nums.length; i++){
           
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
             
        }
        // Step 2: Identify and store the keys to remove
        List<Integer> keysToRemove = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) > 1) {
                keysToRemove.add(key);
            }
        }
        
        // Step 3: Remove the keys with frequency > 1
        for (int key : keysToRemove) {
            map.remove(key);
        }
        for(int key : map.keySet()){
            max= Math.max(max, key);
        }
        return max == 0 ? -1 : max;
    }
}