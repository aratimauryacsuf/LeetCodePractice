class Solution {
    public int[] findErrorNums(int[] nums) {
        
        int[] arr = new int[nums.length+1];
        for(int i : nums){
            arr[i]++;
        }
        int missing =0;
        int repeat =0;
        
        for(int cur= 1; cur <arr.length; cur++){
            if(arr[cur]==2){
                repeat = cur;
            }
            if(arr[cur]==0){
                missing = cur;
            }
        }
        return new int[]{repeat, missing};
    
    }
}