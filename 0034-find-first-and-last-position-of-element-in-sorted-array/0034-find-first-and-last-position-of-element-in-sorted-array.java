class Solution {
    public int[] searchRange(int[] nums, int target) {
      /*  
        int left = 0;
        int right = nums.length-1;
        
        if(nums.length ==1 && target == nums[0]){
            return new int[]{0,0};
        }
        
        while(left < right){
            int mid = (left + right)/2;
            
            if(nums[mid] == target && nums[mid-1] == target){
                return new int[]{mid-1,mid};
            }else if(nums[mid]==target && nums[mid+1] == target){
                return new int[]{mid, mid+1};
            }else if(mid < target) left = mid+1;
            else if(mid > target) right =mid;
        }
        
        return new int[] {-1,-1};
        */
        
        int[] result = new int[2];
    result[0] = findFirst(nums, target);
    result[1] = findLast(nums, target);
    return result;
}

private int findFirst(int[] nums, int target){
    int idx = -1;
    int start = 0;
    int end = nums.length - 1;
    while(start <= end){
        int mid = (start + end) / 2;
        if(nums[mid] >= target){
            end = mid - 1;
        }else{
            start = mid + 1;
        }
        if(nums[mid] == target) idx = mid;
    }
    return idx;
}

private int findLast(int[] nums, int target){
    int idx = -1;
    int start = 0;
    int end = nums.length - 1;
    while(start <= end){
        int mid = (start + end) / 2;
        if(nums[mid] <= target){
            start = mid + 1;
        }else{
            end = mid - 1;
        }
        if(nums[mid] == target) idx = mid;
    }
    return idx;
    }
}