class Solution {
    public long countSubarrays(int[] nums, int k) {
        int maxElement = Arrays.stream(nums).max().getAsInt();
        List<Integer> indexOfMax = new ArrayList<>();
        long ans=0;
        
        for(int i =0; i<nums.length; i++){
            if(nums[i] == maxElement){
                indexOfMax.add(i);
            }
            
            int freq = indexOfMax.size();
            
            if(freq >= k){
                ans += indexOfMax.get(freq -k) +1;
            }
        }
        
        return ans;
    }
}