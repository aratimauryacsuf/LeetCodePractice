class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        
        List<Integer> result = new ArrayList<>();
        
        if(matrix.length == 0){
            return result;
        }
        
        int rowTop = 0;
        int rowBottom =matrix.length -1;
        int colLeft =0;
        int colRight = matrix[0].length -1;
        
        
        while(rowTop<=rowBottom && colLeft<=colRight){
            
            for(int i =colLeft; i<=colRight; i++){
                result.add(matrix[rowTop][i]);
                 //System.out.println("inside left to right");
            }
            rowTop++;
            //System.out.println("rowTop: "+ rowTop);
            
            
            for(int i =rowTop; i<= rowBottom; i++){
                result.add(matrix[i][colRight]);
                //System.out.println("inside rightTop to rightBottom");
            }
            colRight--;
            //System.out.println("colRight: "+ colRight);
            if(rowTop <= rowBottom){
            for(int i= colRight; i>=colLeft;i--){
                result.add(matrix[rowBottom][i]);
            //System.out.println("inside bottomRight to BottomLeft"); 
            }
            }
            rowBottom--;
            //System.out.println("rowBottom: "+ rowBottom);
            
            if(colLeft <= colRight){
               for(int i = rowBottom; i>=rowTop; i--){
                result.add(matrix[i][colLeft]);
                //System.out.println("inside rowBottom to rowTop"); 
            } 
            }
            colLeft++;
            //System.out.println("colLeft: "+ colLeft);
            
            
        }
        
        return result;
    }
}