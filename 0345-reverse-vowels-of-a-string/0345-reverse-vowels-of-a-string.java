class Solution {
    public String reverseVowels(String s) {
        // String vowels = "aeiouAEIOU";
        
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char[] chArray = s.toCharArray();
        
        int start = 0;
        int end = chArray.length-1;
        
        while(start < end){
           
            if(!set.contains(chArray[start])){
                start++;
            }else if(!set.contains(chArray[end])){
                end--;
            }else{ 
            
            char temp = chArray[start];
            chArray[start] = chArray[end];
            chArray[end] = temp;
            start++;
            end--;
                }
        }
        
       return new String(chArray);
    }
}