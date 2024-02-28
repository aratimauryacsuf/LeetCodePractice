class Solution {
    public int numKLenSubstrNoRepeats(String s, int k) {
        if( k > s.length()) return 0;
        int max =0;
       
        int right =0, left =0, count =0;
        // HashSet<Character> set = new HashSet<>();
        int [] frqs = new int[26];
        while(right < s.length()){
               frqs[s.charAt(right) -'a']++;
               while(  frqs[s.charAt(right) -'a'] >1){
                     frqs[s.charAt(left) -'a']--;
                     left++;
               }
               if(right - left +1 == k){
                   count++;
                     frqs[s.charAt(left) -'a']--;
                     left++;
               }
                
            right++;
        
        }
       return count; 
        
    }
}