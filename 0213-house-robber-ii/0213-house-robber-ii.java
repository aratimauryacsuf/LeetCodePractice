class Solution {
    public int rob(int[] nums) {
         if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int n = nums.length;
        int max1 = robbery(0, n-2, nums);
        int max2 = robbery(1, n-1, nums);
        return Math.max(max1, max2);
    }
    private int robbery(int start, int end, int[] nums){
        int r1 =0, r2=0;
        for(int i = start; i <= end; i++){
            int temp = r1;
            r1 = Math.max(r1, r2 + nums[i]);
            r2 = temp;
        }
        return r1;
    }
}