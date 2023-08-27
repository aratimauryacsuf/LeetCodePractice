class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m =s2.length();
        
        if(n > m ) return false;
        
        int[] f1 = new int[26];
        int[] f2 = new int[26];
        
        for(int i =0;i<n;i++){
            f1[s1.charAt(i)-'a']++;
        }
        
        for(int i=0; i<m ;i++){
            f2[s2.charAt(i)-'a']++;
            if(i>=n){
                f2[s2.charAt(i-n)-'a']--;
            }
            
             if(Arrays.equals(f1,f2)) return true;
        }
       
        
        
        return false;
        
    }
}