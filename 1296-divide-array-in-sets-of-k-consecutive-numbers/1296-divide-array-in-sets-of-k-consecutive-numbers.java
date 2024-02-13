class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        
        if(nums.length % k !=0){return false;}
        
        Map<Integer, Integer> count = new HashMap<>();
        
        for(int i : nums){
            count.put(i, count.getOrDefault(i,0)+1);
        }
        
        Arrays.sort(nums);
        
        for(int i =0; i<nums.length;i++){
            if(count.get(nums[i]) ==0 ){ continue;}
               
             for(int j =0; j< k; j++){
                 int curN = nums[i]+j;
                 
                 if(count.getOrDefault(curN, 0)==0){
                     return false;
                 }
                 
                count.put(curN, count.get(curN)-1);
             }
        }
      return true;
    }
}