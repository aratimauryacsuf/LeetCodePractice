class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur= new ArrayList<>();
        backtrack(nums, ans, cur);
        return ans;
        
    }
    
    public void backtrack(int[] nums, List<List<Integer>> ans , List<Integer> cur ){
        if(cur.size() == nums.length){
            ans.add(new ArrayList<>(cur));
            return;
        }
        
        for(int num: nums){
            
            if(!cur.contains(num)){
                cur.add(num);
                backtrack(nums, ans, cur);
                cur.remove(cur.size() -1);
            }
        }
    }
}