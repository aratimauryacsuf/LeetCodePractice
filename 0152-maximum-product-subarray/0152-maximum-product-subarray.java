class Solution {
    public int maxProduct(int[] nums) {
//         int[] dp = new int[nums.length+1];
//         dp[0] = nums[0];
        
//         for(int i=1; i<= nums.length;i++){
//             dp[i] = Math.max(dp[i-1], dp[i] * dp[i-1]);
//         }
        
        // return dp[nums.length];
        
        if(nums.length == 1) return nums[0];
        
        int res = nums[0];
        int max =1, min =1;
        
        for(int n : nums){
            int temp = max * n;
            
            max = Math.max(n, Math.max(temp, min * n));
            min = Math.min(n, Math.min(temp, min * n));
            res = Math.max(res, max);
        }
        
        return res;
        
    }
}