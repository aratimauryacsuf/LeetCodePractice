class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        boolean missing[] = new boolean[len+1];
        
        for(int num: nums){
            if(num > 0 && num <=len){
                missing[num] = true;
            }
        }
        
        for(int i =1; i<=len ; i++){
            if(!missing[i]){
                return i;
            }
        }
        
        return len+1;
    }
}