class Solution {
    public int[][] divideArray(int[] nums, int k) {
        
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
    }
}