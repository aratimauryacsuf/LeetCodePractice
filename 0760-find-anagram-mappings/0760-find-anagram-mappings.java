class Solution {
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res= new int[nums1.length]; 
        int k =0;
        for(int i =0; i < nums2.length; i++){
            map.put(nums2[i], i);
        }
        for(int num : nums1){
           res[k++] = map.get(num);
        }
        return res;
    }
}