class Solution {
    public boolean exist(char[][] board, String word) {
         int m = board.length;
        int n = board[0].length;
        
        for(int i = 0; i< m ;i++){
            for(int j = 0; j< n ; j++){
                if(checkWord(board, word, i, j, m, n, 0)){
                    return true;
                }
            }
        }
        
        return false;
                
    }
    
    public boolean checkWord(char[][] board, String word, int i , int j , int m , int n , int index){
        if(index >= word.length()){
            return true;
        }
        if(i < 0 || j <0 || i == m || j == n || board[i][j] != word.charAt(index))
            return false;
        
        boolean exist = false;
         if(board[i][j] == word.charAt(index)){
             board[i][j] += 100;
             exist = checkWord(board, word, i+1, j, m, n, index+1) ||
                 checkWord(board, word, i, j+1, m, n, index+1) ||
                 checkWord(board, word, i-1, j, m, n, index+1) || 
                 checkWord(board, word, i, j-1, m, n, index+1);
             
            board[i][j] -=100;    
             
         }
        return exist;
    }
    
}