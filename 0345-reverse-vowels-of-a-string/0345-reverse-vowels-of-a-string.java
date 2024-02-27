class Solution {
    public String reverseVowels(String s) {
        String vowels = "aeiouAEIOU";
        char[] chArray = s.toCharArray();
        
        int start = 0;
        int end = chArray.length-1;
        
        while(start < end){
           
            while(start < end && !vowels.contains(chArray[start]+""))
                start++;
        
            while(start < end && !vowels.contains(chArray[end] +""))
                end--;
            
            char temp = chArray[start];
            chArray[start] = chArray[end];
            chArray[end] = temp;
            start++;
            end--;
        }
        
       return new String(chArray);
    }
}