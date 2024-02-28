class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int n =s.length();
        if(n < 3) return n;
        int left =0;
        int right =0;
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen =2;
        while(right < n){
            map.put(s.charAt(right), right++);
            if(map.size() == 3){
                int delIdx = Collections.min(map.values());
                map.remove(s.charAt(delIdx));
                left = delIdx +1;
            }
            maxLen = Math.max(maxLen, right - left);
        }

        return maxLen;
    }
}