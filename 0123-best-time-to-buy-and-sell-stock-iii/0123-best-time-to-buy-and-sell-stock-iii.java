class Solution {
    public int maxProfit(int[] prices) {
//         int profit =0;
        
//         int min = prices[0];
        
//         for(int i =0;i<prices.length;i++){
//             if(prices[i] < min) {min = prices[i];
//             System.out.println("min befor prof cal:" + min);
//             profit = profit + prices[i] -min;}
//             System.out.println("Prof:" + profit);
//             //System.out.println("min after:" + min);
//            // min = prices[i];
            
//         }
//         return profit;
        
   /* way 1     
        int sell1 = 0, sell2 = 0, buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
		for (int i = 0; i < prices.length; i++) {
            System.out.println("Stock when i =: " + prices[i]);
			buy1 = Math.max(buy1, -prices[i]);
            System.out.println("buy1: " + buy1);
			sell1 = Math.max(sell1, buy1 + prices[i]);
            System.out.println("sell1: " + sell1);
			buy2 = Math.max(buy2, sell1 - prices[i]);
            System.out.println("buy2: " + buy2);
			sell2 = Math.max(sell2, buy2 + prices[i]);
            System.out.println("sell2: " + sell2);
		}
		return sell2;
       */
        
       /* way 2 
        int t1Cost = Integer.MAX_VALUE, 
        t2Cost = Integer.MAX_VALUE;
    int t1Profit = 0,
        t2Profit = 0;

    for (int price : prices) {
        // the maximum profit if only one transaction is allowed
        t1Cost = Math.min(t1Cost, price);
        t1Profit = Math.max(t1Profit, price - t1Cost);
        // reinvest the gained profit in the second transaction
        t2Cost = Math.min(t2Cost, price - t1Profit);
        t2Profit = Math.max(t2Profit, price - t2Cost);
    }

    return t2Profit;
    */
        int length = prices.length;
    if (length <= 1) return 0;

    int leftMin = prices[0];
    int rightMax = prices[length - 1];

    int[] leftProfits = new int[length];
    // pad the right DP array with an additional zero for convenience.
    int[] rightProfits = new int[length + 1];

    // construct the bidirectional DP array
    for (int l = 1; l < length; ++l) {
      leftProfits[l] = Math.max(leftProfits[l - 1], prices[l] - leftMin);
      leftMin = Math.min(leftMin, prices[l]);

      int r = length - 1 - l;
      rightProfits[r] = Math.max(rightProfits[r + 1], rightMax - prices[r]);
      rightMax = Math.max(rightMax, prices[r]);
    }

    int maxProfit = 0;
    for (int i = 0; i < length; ++i) {
      maxProfit = Math.max(maxProfit, leftProfits[i] + rightProfits[i + 1]);
    }
    return maxProfit;

    }
}