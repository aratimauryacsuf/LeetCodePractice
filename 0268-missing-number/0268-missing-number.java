class Solution {
    public int missingNumber(int[] nums) {
        
        int sum = nums.length;
        
        for(int i =0; i<nums.length;i++){
            sum ^= i;
            sum ^= nums[i];
        }
        
        return sum;
    }
}