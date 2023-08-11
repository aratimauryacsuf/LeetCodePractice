class Solution {
    public int change(int amount, int[] coins) {
        if(coins.length ==1 && coins[0] == amount) return 1;
        
        int[] a= new int[amount +1];
        
        a[0] =1;
        
        for(int c : coins){
            for(int i=c;i<=amount;i++){
                a[i] = a[i] + a[i-c];
            }
        }
        
        
        return a[amount];
    }
}