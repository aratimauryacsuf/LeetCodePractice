class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i :nums1){
            hm.put(i, hm.getOrDefault(i,0)+1);
        }
        
        List<Integer> res   = new ArrayList<>();
        for(int i: nums2){
            if(hm.get(i) != null && hm.get(i) > 0){
                res.add(i);
                hm.put(i, hm.get(i)-1);
            }
        }
        
   
        
        int[] result = new int[res.size()];
        for(int k =0; k< res.size();k++){
            result[k] = res.get(k);
        }
        
        return result;
    }
}