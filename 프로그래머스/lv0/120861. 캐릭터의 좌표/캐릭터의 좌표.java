class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = new int[2];
        int widthSizeMax = board[0] / 2;
        int widthSizeMin = -board[0] / 2;
        int heigthSizeMax = board[1] / 2;
        int heightSizeMin = -board[1] / 2;
        int inputSize = keyinput.length;
        for(int i = 0; i < inputSize; i++){
            if(keyinput[i].equals("right") && answer[0] < widthSizeMax){
                answer[0] += 1;
            } else if(keyinput[i].equals("left") && answer[0] > widthSizeMin){
                answer[0] -= 1;
            } else if(keyinput[i].equals("up") && answer[1] < heigthSizeMax){
                answer[1] += 1;
            } else if(keyinput[i].equals("down") && answer[1] > heightSizeMin){
                answer[1] -= 1;
            }
        }
        
        return answer;
    }
}