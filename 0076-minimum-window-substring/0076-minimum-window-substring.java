class Solution {
    public String minWindow(String s, String t) {
      /* 
        Map<Character, Integer> map = new HashMap<>();
        
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        
        int start =0;
        int matched=0;
        int minLen = s.length()+1;
        int subStr = 0;
        
        for(int end=0;end<s.length();end++){
            char right = s.charAt(end);
            if(map.containsKey(right)){
                map.put(right, map.get(right)-1 );
                if(map.get(right) == 0) matched++;
            }
            
            while(matched == map.size()){
                if(minLen > end - start +1){
                    minLen = end -start+1;
                    subStr = start;
                }
                
                char del = s.charAt(start++);
                if(map.containsKey(del)){
                    if(map.get(del)==0) matched--;
                    map.put(del,map.get(del)+1);
                }
            }
        }
        
        return minLen>s.length()?"" : s.substring(subStr, subStr+minLen);
    */
       
      /* Method 2   
        String result ="";
        if(s.length() == 0 || t.length() ==0) return result;
        int need = t.length();
        int have = 0;
        int left =0;
        int minWindow =Integer.MAX_VALUE;
        HashMap<Character, Integer> mapt = new HashMap<>();
        HashMap<Character, Integer> mapS = new HashMap<>();
        for(int i =0; i < t.length() ; i++){
            mapt.put(t.charAt(i), mapt.getOrDefault(t.charAt(i), 0)+1);
        }
        int start =0;
       for(int end =0; end < s.length(); end++){
           mapS.put(s.charAt(end),mapS.getOrDefault(s.charAt(end), 0)+1);
           if(mapt.containsKey(s.charAt(end)) && mapS.get(s.charAt(end)) <=
           mapt.get(s.charAt(end))){
               have++;
           }

           while(have == need){
               if(minWindow > end - start +1){
                   minWindow = end - start +1;
                   result = s.substring(start,end +1);
               }
               char removeCh = s.charAt(start);
               if(mapS.get(removeCh) == 1){
                   mapS.remove(removeCh);
               }else{
                   mapS.put(removeCh, mapS.get(removeCh)-1);
               }
               start++;
               if(mapt.containsKey(removeCh) && mapS.getOrDefault(removeCh,0) < (mapt.get(removeCh))){
                   have--;
               }
           }
       }

        return result;
        
        */
        
        /* Method 3 Sliding window

        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        // Dictionary which keeps a count of all the unique characters in t.
        Map<Character, Integer> dictT = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            int count = dictT.getOrDefault(t.charAt(i), 0);
            dictT.put(t.charAt(i), count + 1);
        }

        // Number of unique characters in t, which need to be present in the desired window.
        int required = dictT.size();

        // Left and Right pointer
        int l = 0, r = 0;

        // formed is used to keep track of how many unique characters in t
        // are present in the current window in its desired frequency.
        // e.g. if t is "AABC" then the window must have two A's, one B and one C.
        // Thus formed would be = 3 when all these conditions are met.
        int formed = 0;

        // Dictionary which keeps a count of all the unique characters in the current window.
        Map<Character, Integer> windowCounts = new HashMap<Character, Integer>();

        // ans list of the form (window length, left, right)
        int[] ans = { -1, 0, 0 };

        while (r < s.length()) {
            // Add one character from the right to the window
            char c = s.charAt(r);
            int count = windowCounts.getOrDefault(c, 0);
            windowCounts.put(c, count + 1);

            // If the frequency of the current character added equals to the
            // desired count in t then increment the formed count by 1.
            if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
                formed++;
            }

            // Try and contract the window till the point where it ceases to be 'desirable'.
            while (l <= r && formed == required) {
                c = s.charAt(l);
                // Save the smallest window until now.
                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }

                // The character at the position pointed by the
                // `Left` pointer is no longer a part of the window.
                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
                    formed--;
                }

                // Move the left pointer ahead, this would help to look for a new window.
                l++;
            }

            // Keep expanding the window once we are done contracting.
            r++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
   */
        
       // Method 4 Optimized Sliding Window

        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        Map<Character, Integer> dictT = new HashMap<Character, Integer>();

        for (int i = 0; i < t.length(); i++) {
            int count = dictT.getOrDefault(t.charAt(i), 0);
            dictT.put(t.charAt(i), count + 1);
        }

        int required = dictT.size();

        // Filter all the characters from s into a new list along with their index.
        // The filtering criteria is that the character should be present in t.
        List<Pair<Integer, Character>> filteredS = new ArrayList<Pair<Integer, Character>>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (dictT.containsKey(c)) {
                filteredS.add(new Pair<Integer, Character>(i, c));
            }
        }

        int l = 0, r = 0, formed = 0;
        Map<Character, Integer> windowCounts = new HashMap<Character, Integer>();
        int[] ans = { -1, 0, 0 };

        // Look for the characters only in the filtered list instead of entire s.
        // This helps to reduce our search.
        // Hence, we follow the sliding window approach on as small list.
        while (r < filteredS.size()) {
            char c = filteredS.get(r).getValue();
            int count = windowCounts.getOrDefault(c, 0);
            windowCounts.put(c, count + 1);

            if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
                formed++;
            }

            // Try and contract the window till the point where it ceases to be 'desirable'.
            while (l <= r && formed == required) {
                c = filteredS.get(l).getValue();

                // Save the smallest window until now.
                int end = filteredS.get(r).getKey();
                int start = filteredS.get(l).getKey();
                if (ans[0] == -1 || end - start + 1 < ans[0]) {
                    ans[0] = end - start + 1;
                    ans[1] = start;
                    ans[2] = end;
                }

                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
                    formed--;
                }
                l++;
            }
            r++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    
        
    }
}