class Solution {
    public int change(int amount, int[] coins) {
        if(coins.length == 1 && coins[0] == amount) return 1;
        
        int[] dp = new int[amount+1];
        
        dp[0] =1;
        
        for(int c: coins){
            for(int i = c ; i<= amount; i++){
                dp[i] = dp[i] + dp[i-c];
            }
        }
        
        return dp[amount];
    }
}