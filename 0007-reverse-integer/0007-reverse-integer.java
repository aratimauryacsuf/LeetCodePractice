class Solution {
    public int reverse(int x) {
       /*long rev =0;
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
        */
         int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            //System.out.println("Pop: "+ pop);
            x /= 10;
            //System.out.println("X: "+ x);
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
            //System.out.println("rev: "+ rev);
        }
        return rev;
    
    }
}