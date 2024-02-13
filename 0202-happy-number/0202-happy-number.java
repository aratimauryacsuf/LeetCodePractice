class Solution {
    public boolean isHappy(int n) {
        if(n == 0) return false;
        
        Set<Integer> set = new HashSet<>();
        
        int sum = sumOfNum(n);
        
       // System.out.println("main sum: "+ sum );
        
        while(sum >0){
            sum = sumOfNum(sum);
            //System.out.println("in while sum: "+ sum );
            if(sum == 1){
                return true;
            }else if(!set.contains(sum)){
                set.add(sum);
                
            }else{
                return false;
            }
        }
        
        return false;
    }
    
     public int sumOfNum(int n){
         int sum = 0;
         
         while(n >0){
             sum = sum + (n%10) * (n%10) ;
            // System.out.println("Sum in helper function: "+ sum );
             n = n/10;
             //System.out.println("n: "+ n );
         }
         
         
         return sum;
     }
}