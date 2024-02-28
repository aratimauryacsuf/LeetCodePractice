class Solution {
    public boolean canPermutePalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        for(char ch : s.toCharArray()){
            if(set.contains(ch)){
                set.remove(ch);
            }else{
                set.add(ch);
            }
        }
       
       if(set.size() == 1 || set.size() ==0){
           return true;
       }
       else return false;
    }
}