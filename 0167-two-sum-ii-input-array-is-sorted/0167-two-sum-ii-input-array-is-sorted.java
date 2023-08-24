class Solution {
    public int[] twoSum(int[] num, int target) {
  /*      
    Map<Integer,Integer> map = new HashMap<>();
    
        for(int i=0;i<nums.length;i++){
            
            if(map.containsKey(target - nums[i])){
                return new int[]{(map.get(target -nums[i])), i+1};
            }
            map.put(nums[i],i+1);
        }
       
        return new int[]{};
     */   
        // since array is sorted
          int[] indice = new int[2];
    if (num == null || num.length < 2) return indice;
    int left = 0, right = num.length - 1;
    while (left < right) {
        int v = num[left] + num[right];
        if (v == target) {
            indice[0] = left + 1;
            indice[1] = right + 1;
            break;
        } else if (v > target) {
            right --;
        } else {
            left ++;
        }
    }
    return indice;
    }
}