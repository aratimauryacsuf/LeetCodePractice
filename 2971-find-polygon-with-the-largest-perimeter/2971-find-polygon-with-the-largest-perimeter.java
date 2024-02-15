class Solution {
    public long largestPerimeter(int[] nums) {
       
        /*if(nums.length <=2) return -1;
        Arrays.sort(nums);
        
        long perimeter =nums[0];
        int edge =1;
        for(int i =1 ; i< nums.length; i++){
           if(perimeter > nums[i]){
                perimeter += nums[i];
               edge++;
           }
            else{
                return perimeter;
            }
           
            
        }
        if(edge <3){
            return -1;
        }
        
        
      return perimeter;  
      */
        Arrays.sort(nums);
    long sum = 0;
    for (int n : nums) sum += n;
    for (int i = nums.length - 1; i >= 2; i--) {
        if (nums[i] < sum - nums[i]) return sum;
        sum -= nums[i];
    }
    return -1;
    }
}