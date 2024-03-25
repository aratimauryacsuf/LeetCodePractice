class Solution {
    public List<Integer> findDuplicates(int[] nums) {
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
    }
}