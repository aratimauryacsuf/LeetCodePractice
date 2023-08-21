class Solution {
    public boolean isHappy(int n) {
        if(n ==0 ) return false;
        Set<Integer> set = new HashSet<>();
        int sum = sumOfNum(n);
        
        while(sum > 0){
            sum = sumOfNum(sum);
            
            if(sum == 1){
                return true;
            }else{
                if(!set.contains(sum)){
                   set.add(sum); 
                }else return false;
                
            }
        }
        
      return false;  
    }
    
    public int sumOfNum(int n ){
        int sum =0 ;
        
        while(n > 0){
            sum = sum + (n %10 )* (n % 10);
            n = n / 10;
        }
        
        return sum;
    }
}