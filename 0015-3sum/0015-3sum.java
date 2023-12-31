class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i =0; i<nums.length -2;i++){
            if(i ==0 || (nums[i] != nums[i-1])){
               int left = i+1;
               int right = nums.length -1;
                
                while(left < right){
                    
                    int sum = nums[i] + nums[left] + nums[right];
                    if(sum == 0){
                        ArrayList<Integer> sol = new ArrayList<>();
                        sol.add(nums[i]);
                        sol.add(nums[left]);
                        sol.add(nums[right]);
                        
                        res.add(sol);
                        
                         while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    }else if(sum > 0 ) right--;
                    else if(sum < 0 ) left++;
                    
                }
            }
        }
        
        return res;
    }
}