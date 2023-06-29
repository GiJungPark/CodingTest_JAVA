class Solution {
    public int[] solution(int[][] score) {
        int size = score.length;
        int[] answer = new int[size];
        
        for(int i = 0; i < size; i++){
            answer[i] = 1;
        }
        
        for(int i = 0; i < size; i++){
            for(int n = 0; n < size; n++){
                if(score[i][0] + score[i][1] < score[n][0] + score[n][1])
                    answer[i]++;
            }
        }
        
        return answer;
    }
}