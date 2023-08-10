class Solution {
    public int[] twoSum(int[] nums, int target) {
        // for(int i =0 ;i < nums.length; i++){
        //     for(int j= i+1; j<nums.length; j++){
        //         if(target == nums[i] + nums[j]){
        //             return new int[]{i,j};
        //         }
        //     }
        // }

        Map<Integer, Integer> hMap = new HashMap<>();

        for(int i=0; i< nums.length; i++){
            if(hMap.containsKey(target - nums[i])){
                return new int[]{ hMap.get(target - nums[i]), i };
            }
            hMap.put(nums[i], i);
        }
       return new int[]{} ;
    }
}