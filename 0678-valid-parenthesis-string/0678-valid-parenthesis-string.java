class Solution {
    public boolean checkValidString(String s) {
        int lo = 0, hi = 0;
       for (char c: s.toCharArray()) {
            //System.out.println("C: "+ c);
           lo += c == '(' ? 1 : -1;
           //System.out.println("lo: "+ lo);
           hi += c != ')' ? 1 : -1;
           
//System.out.println("hi: "+ hi);
           if (hi < 0) break;
           lo = Math.max(lo, 0);
          //System.out.println("loMax: "+ lo);  
       }
       return lo == 0;
    }
}