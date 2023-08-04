//정렬 문제?
import java.util.Arrays;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, ((x, y) -> x[1] - y[1]));

        int e = 0;
        for(int i = 0; i < targets.length; i++){
            //System.out.println(targets[i][0] + " " + targets[i][1]); 
            if(targets[i][0] < e) {
                continue;
            }else{
                answer++;
                e = targets[i][1];
            }
        }
        return answer;
    }
}