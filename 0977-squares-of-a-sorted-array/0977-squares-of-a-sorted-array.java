class Solution {
    public int[] sortedSquares(int[] nums) {
        int left =0, right =nums.length-1;
        int[] answer= new int[nums.length];
        int idx= nums.length-1;
        int squareVal = 0;
        
        while(left <= right){
            if(Math.abs(nums[left]) > Math.abs(nums[right])){
                squareVal = nums[left];
                left++;
            }else{
                squareVal = nums[right];
                right--;
            }
            
            answer[idx]= squareVal * squareVal;
            idx--;
        }
        
        return answer;
    }
}