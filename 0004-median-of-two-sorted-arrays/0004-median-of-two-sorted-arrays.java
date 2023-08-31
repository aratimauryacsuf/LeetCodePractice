class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
       int  m= nums1.length, n = nums2.length;
        int[] res = new int[m+n];
        int i =0 , j=0, k=0;
        
        while(k < res.length && (i < m && j<n)){
            if(nums1[i] < nums2[j]){
                res[k] = nums1[i];
                i++;
                k++;
            }else{
                res[k] = nums2[j];
                j++;
                k++;
            }
        }
        
        if(k != res.length){
            while(i < m  && j == n){
                res[k] = nums1[i];
                k++;
                i++;
            }
            while(j <n && i == m){
                res[k] = nums2[j];
                j++;
                k++;
            }
        }
        
        int start =0, end = res.length-1;
        
        int mid = (start + end)/2;
        
        int l = res.length;
       
        return l%2 ==0? ((double)res[mid]+((double)res[mid +1]))/2 :  (double)res[mid];
    }
}