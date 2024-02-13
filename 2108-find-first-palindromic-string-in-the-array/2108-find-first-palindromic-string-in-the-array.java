class Solution {
    public String firstPalindrome(String[] words) {
     
        /* Method 1
        for(int i =0 ; i< words.length ;i++){
            String rev = "";
            String str = words[i];
           
 
        for (int j = str.length() - 1; j >= 0; j--) {
            rev = rev + str.charAt(j);
        }
 
        
        if (str.equals(rev)) {
            return words[i];
        }
        }
        
        return "";
        */
        
         for (String word : words) {
            if (isPalindrome(word)) {
                return word;
            }
        }
        return "";
    }

    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}