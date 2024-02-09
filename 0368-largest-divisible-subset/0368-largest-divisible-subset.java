class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        
        List<Integer> answer = new ArrayList<>();
        
      int[] li = new int[nums.length];
        int[] prev = new int[nums.length];
        
        int max = 0 , index =-1;
        Arrays.sort(nums);
        
        for(int i =0;i<nums.length;i++){
            li[i] =1;
            prev[i] = -1;
            
            for(int j = i-1; j>=0; j--){
                if((nums[i] % nums[j]==0) && li[j]+1 > li[i]){
                    li[i] = li[j]+1;
                    prev[i]=j;
                }
            }
            
            if(li[i] > max){
                max = li[i];
                index=i;
            }
        }
        
        while(index != -1){
            answer.add(nums[index]);
            index = prev[index];
        }
        
       
        return answer;
    }
}