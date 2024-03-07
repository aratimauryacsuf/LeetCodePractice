class Solution {
    int count =0;
    public int findTargetSumWays(int[] nums, int target) {
        backtrack(0, 0, nums, target);
        
        return count;
    }
    
    public void backtrack(int i, int sum, int[] nums, int target ){
        if(i == nums.length && sum == target){
            count++;
        }
        if(i == nums.length){
            return;
        }
        backtrack(i+1, sum + nums[i], nums, target);
        backtrack(i+1, sum - nums[i], nums, target);
    }
}