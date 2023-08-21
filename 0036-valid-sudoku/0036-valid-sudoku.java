class Solution {
    public boolean isValidSudoku(char[][] board) { 
       
        for(int i = 0; i< board.length;i++){
         Set<Character> rSet = new HashSet<>();
            for(int j =0; j<board[0].length;j++){
                
                if(board[i][j] != '.'){
                    if(!rSet.contains(board[i][j])){
                        rSet.add(board[i][j]);
                    }else return false;
                }        
            }
        }
        
       
        for(int i = 0; i< board.length;i++){
             Set<Character> cSet = new HashSet<>();
            for(int j =0; j<board[i].length;j++){
               
                if(board[j][i] != '.'){
                    if(!cSet.contains(board[j][i])){
                        cSet.add(board[j][i]);
                    }else return false;
                }
                
                
                
            }
        }
        
        Set<Character>[] arr = new HashSet[board.length];
        for(int i = 0; i< board.length; i++){
            arr[i] = new HashSet<>();
        }
        
        for(int i = 0; i< board.length;i++){
            for(int j =0; j<board[i].length;j++){
               int k = 3 *(i/3) +(j/3);
              //  System.out.println("i:"+i +" j:"+j+ " k: "+k + " boardValue:"+board[i][j]);
                if(board[i][j] != '.'){
                    if(!arr[k].contains(board[i][j])){
                        arr[k].add(board[i][j]);
                    }else return false;
                }
                
                
                
            }
        }
        
       return true; 
    }
}