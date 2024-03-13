class Solution {
    public int pivotInteger(int n) {
        int leftVal = 1;
        int rightVal = n;
        int sumLeft  = leftVal;
        int sumRight = rightVal;
        
        if(n == 1) return 1;
        
        while(leftVal < rightVal){
           // System.out.println("LeftVal: "+leftVal+" rightVal: "+ rightVal);
            
            if(sumLeft < sumRight){
                leftVal++;
                sumLeft += leftVal ;
                // System.out.println("LeftVal: "+leftVal+" sumLeft: "+ sumLeft);
            }else{
                rightVal--;
                sumRight += rightVal;
               // System.out.println("RightVal: "+rightVal+" sumRight: "+ sumRight);
            }
            
            if((sumLeft  == sumRight) && (leftVal+1) == (rightVal-1)){
               // System.out.println("In 3rd if lopp: "+ (leftVal+1));
               
                return leftVal+1;
            }
            
        }
        
        return -1;
    }
}