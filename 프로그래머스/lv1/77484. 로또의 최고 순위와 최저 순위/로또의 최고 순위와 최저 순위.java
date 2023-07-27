import java.util.Arrays;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int win = 0;
        int lose = 0;
        for(int i = 0; i < 6; i++){
            if(lottos[i] == 0){
                win++;
            }else{
                for(int n = 0; n < 6; n++){
                    if(lottos[i] == win_nums[n]){
                        win++;
                        lose++;
                    }
                }
            }
        }
        int[] answer = {rank(win), rank(lose)};
        return answer;
    }
    public int rank(int num){
        int answer = -1;
        switch (num){
            case 6: answer = 1;
                break;
            case 5: answer = 2;
                break;
            case 4: answer = 3;
                break;
            case 3: answer = 4;
                break;
            case 2: answer = 5;
                break;
            default: answer = 6;
                break;
        }
        return answer;
    }
}