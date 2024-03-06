class Solution {
    Map<Pair<Integer, Boolean>, Integer> map = new HashMap<>();
    
    public int maxProfit(int[] prices) {
        
        return dfs(0, true, prices);
    }
    
    int dfs(int i, boolean buy, int[] prices){
        if(i >= prices.length)
            return 0;
        
        if(map.containsKey(new Pair(i, buy)))
            return map.get(new Pair(i, buy));
                
        if(buy){
            int buyProfit = dfs(i+1, !buy, prices) - prices[i];
            int cooldown =  dfs(i+1, buy, prices);
            map.put(new Pair(i, buy), Integer.max(buyProfit, cooldown));
        }
        else{
            int sellProfit = dfs(i+2, !buy, prices) + prices[i];
            int cooldown =  dfs(i+1, buy, prices);
            map.put(new Pair(i, buy), Integer.max(sellProfit, cooldown));
        }      
        
        return map.get(new Pair(i, buy));
    }
}