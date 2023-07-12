//탐욕법(Greedy)문제인듯
//배열을 정렬해서 적은 예산을 신청한 부서 순으로 최대한 많은 부서를 지원해주면 됨
import java.util.Arrays;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int size = d.length - 1;
        Arrays.sort(d);
        while(d[answer] <= budget){
            if(size == answer) {
                answer++;
                break;
            }else{
                budget -= d[answer++];
            }
        }
        return answer;
    }
}