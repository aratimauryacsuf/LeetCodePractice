class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        
        backtrack(candidates, target, ans, cur, 0);
        return ans;
    }
    
    public void backtrack(int[] candidates, int target, List<List<Integer>> ans, List<Integer> cur, int index){
        
        if(target == 0){
   
            ans.add(new ArrayList<>(cur));
           //  System.out.println("Ans: "+ ans + " target: "+ target + " index: "+ index);
        
        }else if(target <0 || index >= candidates.length){
            return;
        }else{
           // System.out.println("Add in Cur:");
            cur.add(candidates[index]);
          //  System.out.println("cur: "+ cur + " target: "+ target + " index: "+ index);
            backtrack(candidates, target - candidates[index], ans, cur, index);
            
            //System.out.println("remove in Cur:");
            cur.remove(cur.get(cur.size()-1));
            //System.out.println("remove cur: "+ cur + " target: "+ target + " index: "+ index);
            backtrack(candidates, target, ans, cur, index+1);
        }
    }
}