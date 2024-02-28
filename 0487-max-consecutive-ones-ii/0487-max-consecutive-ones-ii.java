class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        // HashMap<Integer, Integer> map = new HashMap<>();
        int left =0;
        int right =0;
        int max =0, count =0;
        while(right < nums.length){
           if(nums[right++] == 0){
               count++;
           }
           if(count >1){
               if(nums[left] == 0) count--;
               left++;
           }

            max = Math.max(max, right -left);
        }
        return max;
    }
}