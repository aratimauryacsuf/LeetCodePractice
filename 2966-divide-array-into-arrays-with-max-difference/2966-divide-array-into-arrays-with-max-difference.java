class Solution {
    public int[][] divideArray(int[] nums, int k) {
      /* method 1  
        if((nums.length % 3) != 0){
            return new int[0][0];
        }
        
        Arrays.sort(nums);
        
        int[][] ans = new int[nums.length /3][3];
        int index =0;
        
        for(int row =0; row<ans.length ;row++){
            for(int i=0; i< 3;i++){
                ans[row][i] = nums[index++];
            }
            if(ans[row][2] - ans[row][0] > k){
                return new int[0][0];
            }
        }
        
        return ans;
        
        */
        // Method 2
        
        Arrays.sort(nums);
        int[][] ans = new int[nums.length / 3][3];
        for (int i = 0; i < nums.length; i += 3) {
            if (nums[i + 2] - nums[i] > k) {
                return new int[0][0];
            }
            ans[i / 3] = new int[]{nums[i], nums[i + 1], nums[i + 2]};
        }
        return ans;
    }
}