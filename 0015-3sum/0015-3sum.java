class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        
        if(nums.length <3) return new ArrayList<>(result);
        
        Arrays.sort(nums);
        
        for(int i =0; i< nums.length-2;i++){
            if(i ==0 || nums[i] != nums[i-1]){
                
            
          int  left = i+1;
           int right = nums.length-1;
            
            while(left < right){
              int  sum = nums[i]+nums[left]+nums[right];
                if(sum ==0){
                    result.add(Arrays.asList(nums[i], nums[left++], nums[right--]));
                }else if(sum >0) right--;
                else if(sum < 0) left++;
            }
        }
        }
        
        return new ArrayList<>(result);

    }
}