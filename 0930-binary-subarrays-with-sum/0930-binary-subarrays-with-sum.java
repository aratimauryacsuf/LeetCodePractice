class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int start = 0;
        int prefixZeros = 0;
        int currentSum = 0;
        int totalCount = 0;

        // Loop through the array using end pointer
        for (int end = 0; end < nums.length; end++) {
            // Add current element to the sum
            currentSum += nums[end];
            
           // System.out.println("currenSum befor while: "+ currentSum);
            
            // Slide the window while condition is met
            while (start < end && (nums[start] == 0 || currentSum > goal)) {
             //  System.out.println("Start: "+ start);
                if (nums[start] == 1) {
                    prefixZeros = 0;
                } else {
                    prefixZeros++;
                }
                
               // System.out.println("PRefixZeros: "+ prefixZeros);
                currentSum -= nums[start];
               // System.out.println("currenSum Inside  while: "+ currentSum);
                start++;
            }
            
           // System.out.println("currenSum After while: "+ currentSum);
            
            // Count subarrays when window sum matches the goal
            if (currentSum == goal) {
                
                totalCount += 1 + prefixZeros;
             //   System.out.println("totalcount: "+ totalCount);
            }
        }
        
        return totalCount;
    }
}