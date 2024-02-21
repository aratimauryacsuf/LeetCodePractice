class Solution {
    public int rangeBitwiseAnd(int left, int right) {
//         int res=left;
//         while(left <right){
//             res = res &(left+1);
//             left++;
//         }
        
//         return res;
        
        int count =0;
        
        while(left != right){
            left >>= 1;
            right >>= 1;
            count++;
            
        }
        
        return left<<count;
    }
}