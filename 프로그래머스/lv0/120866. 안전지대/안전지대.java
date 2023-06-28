class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int boardSize = board.length;
        int[][] boardAnswer = new int[boardSize+2][boardSize+2];
        
        for(int i = 0; i < boardSize; i++){
            for(int n = 0; n < boardSize; n++){
                boardAnswer[i+1][n+1] = board[i][n];
            }
        }
        
        for(int i = 1; i <= boardSize; i++){
            for(int n = 1; n <= boardSize; n++){
                if(boardAnswer[i-1][n-1] != 1 && boardAnswer[i][n-1] != 1 
                   && boardAnswer[i+1][n-1] != 1 && boardAnswer[i-1][n] != 1 
                   && boardAnswer[i+1][n] != 1 && boardAnswer[i+1][n] != 1 
                   && boardAnswer[i-1][n+1] != 1 && boardAnswer[i][n+1] != 1 
                   && boardAnswer[i+1][n+1] != 1 && boardAnswer[i][n] != 1){
                    answer++;
                }
            }
        }
        
        return answer;
    }
}