class Solution {
    public int solution(int order) {
        int answer = 0;
        while(order > 0){
            int step = order % 10;
            if(step != 0 && step % 3 == 0) answer++;
            order = order / 10;
        }
        return answer;
    }
}