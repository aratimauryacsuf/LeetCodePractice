class Solution {
    public String maximumOddBinaryNumber(String s) {
        int n = s.length();
        
        int ones =0;
        
        for(int i=0;i<n;i++){
            ones += s.charAt(i) -'0';
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i =0; i<ones-1; i++){
            sb.append("1");
        }
        for(int i =0; i< n-ones; i++){
            sb.append("0");
        }
        sb.append("1");
        
        return sb.toString();
        
    }
}