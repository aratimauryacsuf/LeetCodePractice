class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k%len;
        if(k <0){
            k += len;
        }
        
        reverse(nums, 0, len-k-1);
        reverse(nums, len-k, len-1);
        reverse(nums, 0, len-1);
            
    }
    
    public void reverse(int[] nums, int i , int j){
        int left= i;
        int  right = j;
        
        while(left < right){
            int temp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = temp;
        }
    }    
}