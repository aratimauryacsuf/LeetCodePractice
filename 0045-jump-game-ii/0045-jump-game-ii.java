class Solution {
    public int jump(int[] nums) {
        int count=0, curEnd =0, curFar =0;
        
        for(int i=0; i< nums.length -1; i++){
            curFar = Math.max(curFar, i+nums[i]);
           
            if(i == curEnd){
                
                count++;
               
                curEnd = curFar;
                
            }
        }
        return count;
    }
}