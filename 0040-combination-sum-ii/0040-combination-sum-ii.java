class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
       Arrays.sort(candidates);
        
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        combination(candidates, target, 0,0, ans, list);
        return ans;
    }
    
    public void combination(int[] candidates, int target, int idx, int sum, List<List<Integer>> ans, List<Integer> list ){
        
        if(sum == target){
            ans.add(new ArrayList<>(list));
        }else if(sum > target){
            return;
        }else 
        {
            for(int i = idx; i< candidates.length; i++){
                
                if(i> idx && candidates[i] == candidates[i-1]) continue;
                
                list.add(candidates[i]);
                combination(candidates, target, i+1, sum + candidates[i], ans, list);
                list.remove(list.size() -1);
            }
        }
        
    }
}