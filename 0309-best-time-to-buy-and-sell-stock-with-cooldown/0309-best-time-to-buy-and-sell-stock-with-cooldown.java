class Solution {
    Map<String, Integer> cache = new HashMap<>();
    public int maxProfit(int[] prices) {
        
        return dfs(0, true, prices);
    }
    
    public int dfs (int index, boolean buying, int[] prices){
        
        if(index >= prices.length){
            return 0;
        }
        
        String key = index +"-"+buying;
        
        if(cache.containsKey(key)){
            return cache.get(key);
        }
        
        int cooldown = dfs(index+1, buying, prices);
        
        int buyOrSell = Integer.MIN_VALUE;
        
        if(buying){
            buyOrSell = dfs(index+1, !buying, prices) - prices[index];
        }
        else{
            buyOrSell = dfs(index+2, !buying, prices) + prices[index];
        }
        
        cache.put(key, Math.max(cooldown, buyOrSell));
        
        return cache.get(key);
    }
   
}
