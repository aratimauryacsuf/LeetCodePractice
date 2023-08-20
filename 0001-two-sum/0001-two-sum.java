class Solution {
    public int[] twoSum(int[] nums, int target) {
        // for(int i =0 ;i < nums.length; i++){
        //     for(int j= i+1; j<nums.length; j++){
        //         if(target == nums[i] + nums[j]){
        //             return new int[]{i,j};
        //         }
        //     }
        // }

      Map<Integer, Integer> map = new HashMap<>();
        
        for(int i =0; i < nums.length ;i++){
            if(map.containsKey(target - nums[i])){
                return new int[]{ map.get(target - nums[i]), i};
            }
            map.put(nums[i],i);
        }
        
        return new int[]{};
    }
}