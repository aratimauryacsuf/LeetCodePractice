class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length ==0) return 0;
        Arrays.sort(nums);
        int count =0;
        if(nums.length >0) count =1;
        for(int i =0; i<nums.length;i++){
            System.out.print(nums[i] +" ");
        }
        System.out.println();
        int max = 1;
        
        for(int i =0; i<nums.length-1;i++){
            if(nums[i] == nums[i+1]) continue;
            if(nums[i]  == nums[i+1] - 1 ){
              count++;  
            max = Math.max(max,count);
            System.out.println(count +"is"+ nums[i]);
            }
            else{
                max = Math.max(max,count);
                count =1;
            }
        }
        
        return max;
    }
}