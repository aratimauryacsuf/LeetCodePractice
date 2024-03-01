class Solution {
    public String maximumOddBinaryNumber(String s) {
      // Method 1: Greedy - counting bits 0(n)
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
        
        /* method2 nlogn
        char[] ch  = s.toCharArray();
        int n = ch.length;
        
        Arrays.sort(ch);
        int secLast = n-2;
        
        for(int i =0; i< n/2; i++){
            char temp = ch[i];
            ch[i] = ch[secLast -i];
            ch[secLast -i] = temp;
        }
        
        
      return new String(ch);  */
    }
}