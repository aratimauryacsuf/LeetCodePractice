class Solution {
    public List<Integer> findDuplicates(int[] nums) {
       /*
        Map<Integer, Integer> map = new HashMap<>();
         List<Integer> result = new ArrayList<>();
        
        for(int num: nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
       
        for(int num:nums){
            if(map.containsKey(num) && map.get(num) >1){
                result.add(num);
                map.remove(num);
            }
        }
        
        return result;
    */
        List<Integer> result = new ArrayList<>();
        for(int i =0 ;i<nums.length;i++){
            int index = Math.abs(nums[i]);
            
            if(nums[index-1] < 0){
                result.add(index);
            }else{
                nums[index-1] *= -1;
            }
                
        }
        
        return result;
    }
}