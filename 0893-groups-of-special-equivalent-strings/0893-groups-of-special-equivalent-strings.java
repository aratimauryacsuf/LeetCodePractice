class Solution {
    public int numSpecialEquivGroups(String[] words) {
         Set<String> set= new HashSet<>();
        for (String s: words){
            int[] odd= new int[26];
            int[] even= new int[26];
            for (int i=0; i<s.length(); i++){
                if (i%2==1) odd[s.charAt(i)-'a']++;
                else even[s.charAt(i)-'a']++;
            }
            String sig= Arrays.toString(odd)+Arrays.toString(even);
            
           // System.out.println("S: "+ s +"  sig: "+ sig);
            
            set.add(sig);
        }
        return set.size();
    }
}