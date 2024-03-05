class Solution {
    public int minimumLength(String s) {
        
        if(s.length() == 1) return 1;
        
        int left = 0;
        int right = s.length()-1;
        
        while(left < right){
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            
            if(leftChar == rightChar){
                while(s.charAt(left)== leftChar && left < right){
                    left++;
                }
                if(left == right)
                    return 0;
                while(s.charAt(right) == rightChar && right > left){
                    right--;
                }
                // if(left == right)
                //     return 0;
            }else{
                break;
            }
            
            
            
        }
        
        return right - left+1;
    }
}