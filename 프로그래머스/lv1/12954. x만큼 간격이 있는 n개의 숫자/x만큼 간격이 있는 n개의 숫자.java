class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        int count = 0;
        long step = x;
        while(count < n){
            answer[count++] = step;
            step += x;
        }
        return answer;
    }
}