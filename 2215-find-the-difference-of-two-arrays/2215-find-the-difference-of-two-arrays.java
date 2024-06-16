class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> result = new ArrayList<>();
        
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        
        for(int n : nums1){
            set1.add(n);
        }
        
        for(int n : nums2){
            set2.add(n);
        }
        
        
        List<Integer> list1 = new ArrayList<>();
        for(int n : nums1){
            if(!set2.contains(n) && !list1.contains(n)){
                list1.add(n);
            }
        }
        
         List<Integer> list2 = new ArrayList<>();
        for(int n : nums2){
            if(!set1.contains(n) && !list2.contains(n)){
                list2.add(n);
            }
        }
        
        result.add(list1);
        result.add(list2);
        
        return result;
    }
}