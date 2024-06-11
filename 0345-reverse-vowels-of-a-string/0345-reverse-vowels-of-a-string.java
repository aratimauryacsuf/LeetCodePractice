class Solution {
    public String reverseVowels(String s) {
        
        Set<Character> set = new HashSet<>(Arrays.asList('a','e', 'i', 'o', 'u','A','E','I', 'O','U'));
        
        char[] charArray = s.toCharArray();
        
        int start = 0;
        int end = charArray.length -1;
        
        while(start < end){
            if(!set.contains(charArray[start])){
                start++;
            }else if(!set.contains(charArray[end])){
                end--;
            } else{
                char temp = charArray[start];
                charArray[start] = charArray[end];
                charArray[end] = temp;
                start++;
                end--;
            }
        }
        
        return new String(charArray);
    }
}