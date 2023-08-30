class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left =1,right =1;
        
        for(int pile: piles){
            right = Math.max(right, pile);
        }
        
        while(left < right){
            int k = (left+ right)/2;
            int hourS = 0;
           
            for(int pile:piles){
                hourS+= Math.ceil(((double)pile/(double)k));
            }
            
            if(hourS <= h){
                right =k;
            }else{
                left = k+1;
            }
           // System.out.println("k :"+ k + " left: "+ left + " right: "+ right +" hours: "+hourS);
        }
        
        return right;
    }
}