class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        if(s.length() < k) return s.length();
        int left =0;
        int right =0;
        int maxLen =k;
        while(right < s.length()){
         map.put(s.charAt(right), right++);
         if(map.size() > k){
             int delIdx = Collections.min(map.values());
             map.remove(s.charAt(delIdx));
            left = delIdx +1;
         }
           maxLen = Math.max(maxLen, right - left);
        }
       return maxLen; 
    }
}