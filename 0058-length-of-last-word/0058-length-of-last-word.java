class Solution {
    public int lengthOfLastWord(String s) {
       int sLen = s.length(), wLen =0;
        
        for(int i = sLen-1; i >= 0; i--){
            if(s.charAt(i) != ' '){
                wLen++;
            }
            
            if(s.charAt(i) == ' '  && wLen != 0){
                return wLen;
            }
        }
        
        return wLen;
    }
}