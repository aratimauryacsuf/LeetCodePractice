class Solution {
    public int removeElement(int[] nums, int val) {
        
        //Using two pointer
        int i = 0;
        
        for(int j=0;j<nums.length;j++){
            if(nums[j]!=val){
              int temp = nums[i]; // whenever element is not value shift it to start of array
                nums[i]=nums[j];
                nums[j]=temp;
                i++;
            }
        }
       
        return i;
    }
}