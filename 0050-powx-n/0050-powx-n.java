class Solution {
    public double myPow(double x, int n) {
        if(n < 0){
            n = -n;
            x = 1/x; // when negative eg 2^-2 = 1/2^2 = 1/4=0.25 so x=0.25
        }
    double power =1.0;
        int count =1;
    while( n !=0){
        if((n & 1) != 0)
            power = power * x;
        
        x = x*x;
        n = n >>>1;
    }
      
        return power;
    }
}