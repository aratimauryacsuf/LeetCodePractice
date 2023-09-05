class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast =0;
        
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);
        
        slow = 0;
        
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
            return slow;
        
        
        
      /*  HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], 1);
            }else{
               // map.put(nums[i], map.get(nums[i])+1);
                
                return nums[i];
            }
        }
       /* int num =-1;
        for(int i=0; i<nums.length; i++){
            if(map.get(nums[i]) > 1){
                 num = nums[i];
            }
        }
        */
        /*
        int sum = 0;
        
        for(int i = 0 ; i< nums.length;i++){
           sum = sum + nums[i]; 
        }
        int n = nums.length -1;
        
        int number_sum = (n *(n+1))/2;
        
        int ans = sum - number_sum ;
        
        return ans;
        */
    }
}