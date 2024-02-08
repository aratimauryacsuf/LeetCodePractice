public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
       if(n == 0) return 0;
        int count=0;
      //  System.out.println("n: "+ n);
        while(n!= 0){
           // System.out.println("n & 1: "+ (n & 1));
            count = count + (n& 1);
            n = n >>>1;
           // System.out.println( "n after shift: "+n);
        }
        return count;
        
    }
}