class Solution {
    public int characterReplacement(String s, int k) {
        int len = s.length();
        int[] arr =new int[26];
        int start =0;
        int maxCount =0, maxLength =0;
        for(int end =0; end <len; end++){
            maxCount = Math.max(maxCount, ++arr[s.charAt(end) -'A']);
            
            while(end-start+1 - maxCount >k){
                arr[s.charAt(start)-'A']--;
                start++;
            }
            
            maxLength = Math.max(maxLength, end-start+1);;
        }
      
        return maxLength;
    }
}