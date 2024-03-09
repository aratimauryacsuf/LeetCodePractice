class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        
     /* brute force
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i<nums1.length; i++){
            for(int j =0; j<nums2.length; j++){
                if(nums1[i] == nums2[j]){
                    min = Math.min(min , nums1[i]);
                }
            }
        }
       
        return min == Integer.MAX_VALUE? -1 : min;
        */
        
     /*   // using set
        Set<Integer> set = new HashSet<>();
        int l1 = nums1.length;
        int l2 = nums2.length;
        
       if(l1 < l2){
            for(int i = 0 ; i < l1; i++){
                set.add(nums1[i]);
            }
           
           for(int i =0; i<l2;i++){
               if(set.contains(nums2[i]))
                   return nums2[i];
           }
           
       }else{
           for(int i = 0 ; i < l2; i++){
                set.add(nums2[i]);
            }
           for(int i =0; i<l1;i++){
               if(set.contains(nums1[i]))
                   return nums1[i];
           }
           
       }
        
        
       return -1; 
       */
        
    /*
        //Using two pointer
        
        int p1  = 0;
        int p2  =0;
        
        while(p1 < nums1.length && p2 < nums2.length){
            
            if(nums1[p1] == nums2[p2]){
                return nums1[p1];
            }
            
                if(nums1[p1] < nums2[p2]){
                    p1++;
                }else{
                    p2++;
                }
            
            
        }
        
       return -1; 
       
       */
        
        
       if(nums1.length > nums2.length){
           getCommon(nums2, nums1);
       } 
        
        for(int num: nums1){
            if(binarySearch(num, nums2)){
                return num;
            }
        }
       return -1; 
    }
    
    public boolean binarySearch(int target, int[] nums){
        int left = 0 ;
        int right = nums.length -1;
        
        while(left <= right){
            int mid = left + (right  - left)/2;
            
            if(nums[mid] > target){
                right = mid -1;
            }else if(nums[mid] < target){
                left = mid +1;
            }else{
                return true;
            }
        }
        
        return false;
    }
}