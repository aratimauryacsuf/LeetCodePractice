class Solution {
    public String firstPalindrome(String[] words) {
        
        for(int i =0 ; i< words.length ;i++){
            String rev = "";
            String str = words[i];
           
 
        for (int j = str.length() - 1; j >= 0; j--) {
            rev = rev + str.charAt(j);
        }
 
        // Checking if both the strings are equal
        if (str.equals(rev)) {
            return words[i];
        }
        }
        
        return "";
    }
}