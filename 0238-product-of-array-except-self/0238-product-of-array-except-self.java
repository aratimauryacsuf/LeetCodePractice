class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
      
        /*
        // brute force
        for(int i = 0; i<nums.length;i++){;
            int product =1;
            for(int j =0; j< nums.length; j++){
                if(i != j ){
                    product = product * nums[j];
                }
            }
            answer[i] = product;
        }
        */
       /* 
        int prod = 1;
        for(int i : nums){
            prod =prod * i;
        }
        
        for(int i = 0 ; i < nums.length; i++){
            answer[i] = prod / nums[i];
        }
        */
        
        int prod =1; 
        for(int i = 0 ;i < nums.length;i++){
            answer[i] = prod;
          //  System.out.println("answer1: "+ answer[i]);
            prod *= nums[i];
        }
        
        prod =1;
        for(int i = nums.length -1; i>=0;i--){
            
            answer[i]*= prod;
            // System.out.println("answer2: "+ answer[i]);
            prod*= nums[i];
        }
        
        return answer;
    }
}