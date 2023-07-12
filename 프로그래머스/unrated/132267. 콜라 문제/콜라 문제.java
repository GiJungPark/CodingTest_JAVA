//빈병 a병을 가져가면
//콜라 b병을 준다.
//빈병 n개를 가져가면
//총 몇 병의 콜라를 받을 수 있는가.

class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while(n >= a){
            int step = (int)(n / a);
            n = n + (step *(b - a));
            answer += b * step;
        }
        return answer;
    }
}