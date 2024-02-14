class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] positive = new int[nums.length / 2];
        int[] negative = new int[nums.length /2];
        int pIdx =0;
        int nIdx =0;
        for(int i=0; i< nums.length; i++){
            if(nums[i] > 0){
                positive[pIdx++] = nums[i];
            }else{
                negative[nIdx++] = nums[i];
            }
        }
        
        int j=0, k=0;
        
        int[] result = new int[nums.length];
        for(int i=0; i< nums.length; i++){
            if(i %2 ==0){
                result[i] = positive[j++];
            }else{
                result[i] = negative[k++];
            }
            
        }
        
        return result;
    }
}