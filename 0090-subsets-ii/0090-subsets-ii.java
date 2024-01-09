class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        subSet(nums, 0, ans, list);
        return ans;
    }

    public void subSet(
        int[] nums,
        int idx,
        List<List<Integer>> ans,
        List<Integer> list
    ) {
        ans.add(new ArrayList<>(list));
        //System.out.println("ans: "+ ans);
        
       // System.out.println("idx before for loop: "+ idx);

        for (int i = idx; i < nums.length; i++) {
           // System.out.println("idx: "+ idx);
            //skip the duplicate elements
            if (i > idx && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);
            // System.out.println("list: "+ list);
            subSet(nums, i + 1, ans, list);
            list.remove(list.size() - 1);
           // System.out.println("after removal list: "+ list);
        }
}
}