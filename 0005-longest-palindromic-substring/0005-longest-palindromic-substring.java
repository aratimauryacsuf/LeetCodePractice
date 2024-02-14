class Solution {
    private int lo, maxLen;
    public String longestPalindrome(String s) {
        if(s.length() <2) return s;
        
        for(int i =0; i< s.length()-1; i++){
            
           palindromLength(s,i,i); // check for odd length
            
            palindromLength(s,i, i+1); //check for even length
        }
        
       // System.out.println("lo: "+ lo +" maxLen: "+ maxLen );
        
        return s.substring(lo, lo + maxLen);
    }
    
    public void palindromLength(String s, int j, int k){
       // System.out.println("j: "+ j +" k: "+ k );   
        while(j >=0  && k < s.length() && (s.charAt(j) == s.charAt(k))){
            j--;
            k++;
       //  System.out.println(" j: "+ j +" k: "+ k );   
        }
        
       // System.out.println("maxLen: "+ maxLen);
       // System.out.println("k - j -1 :" + (k - j -1));
        
        if(maxLen < k - j -1){
            lo = j+1;
            maxLen = k-j-1;
        }
    }
}