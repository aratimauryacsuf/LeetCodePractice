//Using map

/*class Solution {
   // int count =0;
     // Map<String, Integer> cache = new HashMap<>();
    public int findTargetSumWays(int[] nums, int target) {
          
        return backtrack(0, 0, nums, target);
    }
    
    public int backtrack(int i, int sum, int[] nums, int target ){
        if(i == nums.length){
            if(sum == target){
                return 1;
            }
            else{
                return 0;
            }
        } 
        String key = i+"-"+sum;
        
        if(cache.containsKey(key)){
            return cache.get(key);
        }
        
        int add = backtrack(i+1, sum + nums[i], nums, target);
        int sub = backtrack(i+1, sum - nums[i], nums, target);
        
        cache.put(key , (add+sub));
        
        return cache.get(key);
    }
}
*/

// using arrays
public class Solution {
    int total;
    
    public int findTargetSumWays(int[] nums, int S) {
        total = Arrays.stream(nums).sum();
        
        int[][] memo = new int[nums.length][2 * total + 1];
        for (int[] row : memo) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        return calculate(nums, 0, 0, S, memo);
    }
    
    public int calculate(int[] nums, int i, int sum, int S, int[][] memo) {
        if (i == nums.length) {
            if (sum == S) {
                return 1;
            } else {
                return 0;
            }
        } else {
            if (memo[i][sum + total] != Integer.MIN_VALUE) {
                return memo[i][sum + total];
            }
            int add = calculate(nums, i + 1, sum + nums[i], S, memo);
            int subtract = calculate(nums, i + 1, sum - nums[i], S, memo);
            memo[i][sum + total] = add + subtract;
            return memo[i][sum + total];
        }
    }
}

