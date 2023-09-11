import java.util.*;

class Solution {
    public int solution(int N, int number) {
        Set<Integer>[] dp = new Set[8 + 1];
        
        for(int i = 1; i <= 8; i++){
            dp[i] = new TreeSet<>();
        }
        
        for(int i = 1; i <= 8; i++){
            dp[i].add(Integer.parseInt(Integer.toString(N).repeat(i)));
        }
        
        for(int j = 1; j <= 8; j++){
            for(int k = 1; k < j; k++){
                for (int m : dp[k]) {  
                    for (int n : dp[j - k]) {  
                        dp[j].add(m + n);  
                        dp[j].add(m - n);  
                        dp[j].add(m * n);  
                        if(n != 0) {  
                            dp[j].add(m / n);  
                        }  
                    }  
                } 
            }
        }
        
        int answer = -1;
        for(int i = 1; i <= 8; i++){
            if(dp[i].contains(number)){
                answer = i;
                break;
            }
        }
        
        return answer;
    }
}