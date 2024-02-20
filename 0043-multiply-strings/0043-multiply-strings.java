class Solution {
    public String multiply(String num1, String num2) {
        
        int len1 = num1.length();
        int len2 = num2.length();
        
        if(len1 == 0 || len2 == 0){
            return "0";
        }
        
        int[] result = new int[len1+len2];
        
        int idx1 =0;
        int idx2 =0;
        
        for(int i = len1 - 1;i >=0;i--){
            int carry =0;
            int n1 = num1.charAt(i) -'0';
            idx2 = 0;
            
            for(int j= len2-1; j >= 0; j--){
                
                int n2 = num2.charAt(j) - '0';
                
                int sum = n1 * n2 + result[idx1 + idx2] +carry;
                
                carry = sum / 10;
                
                result[idx1 + idx2] = sum % 10;
                
                idx2++;
                
            }
            
            if(carry > 0){
                result[idx1 + idx2] = carry;
            }
            
            idx1++;
        }
        
        int i =result.length -1;
        
        while(i >=0 && result[i] == 0){
            i--;
        }
        if(i == -1){
            return "0";
        }
        
        String multiplication_res = "";
        
        while(i >=0){
            multiplication_res += result[i--];
        }
        
        return multiplication_res;
        
    }
    
}