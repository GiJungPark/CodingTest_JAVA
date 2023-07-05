class Solution {
    public long solution(long n) {
        long answer = -1;
        double step = Math.sqrt(n);
        if(step == (int)step) answer = (long)Math.pow(step + 1, 2);
        return answer;
    }
}