class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i = 1; i <= n; i++){
            int step = 0;
            for(int s = 1; s <= i; s++){
                if(i % s == 0) step++;
            }
            if(step >= 3) answer++;
        }
        
        return answer;
    }
}