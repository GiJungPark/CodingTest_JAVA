//dp를 사용하여 뒤에서 부터 조합 가능한 단어수가 가장 적은 문자열 조합으로 진행
class Solution {
    public int solution(String[] strs, String t) {
        int answer = 0;
        int[] dp = new int[t.length()];
        for(int i = t.length() - 1; i >= 0; i--){
            for(String step : strs){
                if(step.length() > t.length() - i) {
                    continue;
                } else if(step.equals(t.substring(i, i + step.length()))){
                    if(t.length() - i == step.length()){
                        dp[i] = 1;
                        continue;
                    }
                    if(dp[i + step.length()] > 0){
                    dp[i] = dp[i] == 0 ? dp[i + step.length()] + 1 : Math.min(dp[i], dp[i + step.length()] + 1);
                    }   
                }
            }
        }
        answer = dp[0];
        if(answer == 0) answer = -1;
        return answer;
    }
}