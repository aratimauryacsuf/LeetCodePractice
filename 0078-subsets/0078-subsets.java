class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        
        helper(nums, 0, list, ans);
        return ans;
    }
    
    public void helper(int[] nums, int index, List<Integer> list, List<List<Integer>> ans){
        if(index >= nums.length){
            ans.add(new ArrayList<>(list));
        } else{
            list.add(nums[index]);
            helper(nums, index+1, list, ans);
            
            list.remove(list.size()-1);
            helper(nums, index+1, list, ans);
        }
    }
}