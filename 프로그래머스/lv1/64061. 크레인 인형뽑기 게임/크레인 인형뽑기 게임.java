import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> st = new Stack<>();
        for(int i : moves){
            int j = i - 1;
            int step = 0;
            
            for(int k = 0; k < board[0].length; k++){
                if(board[k][j] != 0){
                    step = board[k][j];
                    board[k][j] = 0;
                    if(!st.isEmpty()){
                        if(step == st.peek()){
                            answer += 2;
                            st.pop();
                        }else{
                            st.add(step);
                        }
                    }else{
                        st.add(step);
                    }
                    break;
                }
            }
        }
        return answer;
    }
}