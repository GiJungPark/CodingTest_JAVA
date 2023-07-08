class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i = 1; i <= n; i++){
            int step = i;
            int count = 0;
            while(count < n){
                count += step++;
            }
            if(count == n) answer++;
        }
        return answer;
    }
}