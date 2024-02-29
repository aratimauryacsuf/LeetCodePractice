class Solution {
    public boolean canPartition(int[] nums) {
         int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false;

        int target = sum / 2;
      //  System.out.println("target:" + target);
        boolean[] dp = new boolean[target];
        dp[0] = true;

        for (int no : nums) {
            for (int i = target; i >= no; i--) {
                if (dp[i - no] == true) {
                  //  System.out.println("i: "+ i);
                    if (i == target) return true;
                    dp[i] = true;
                }
            }
        }
        return false;
    }
}