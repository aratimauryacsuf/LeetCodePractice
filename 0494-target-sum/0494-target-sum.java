class Solution {
   // int count =0;
      Map<String, Integer> cache = new HashMap<>();
    public int findTargetSumWays(int[] nums, int target) {
          
        return backtrack(0, 0, nums, target);
    }
    
    public int backtrack(int i, int sum, int[] nums, int target ){
        if(i == nums.length){
            if(sum == target){
                return 1;
            }
            else{
                return 0;
            }
        } 
        String key = i+"-"+sum;
        
        if(cache.containsKey(key)){
            return cache.get(key);
        }
        
        int add = backtrack(i+1, sum + nums[i], nums, target);
        int sub = backtrack(i+1, sum - nums[i], nums, target);
        
        cache.put(key , (add+sub));
        
        return cache.get(key);
    }
}