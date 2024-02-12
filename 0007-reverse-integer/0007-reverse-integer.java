class Solution {
    public int reverse(int x) {
       long rev =0;
        while(x != 0){
            rev+= (x % 10);
            rev = rev *10;
            x = x /10;
        }
        rev = rev /10;
        
        if(x < 0){return -(int)rev;}
        
        if(rev < Integer.MIN_VALUE || rev > Integer.MAX_VALUE){
            return 0;
        }
        
        return (int)rev;
    }
}