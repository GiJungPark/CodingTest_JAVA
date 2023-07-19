import java.util.Arrays;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] player = new int[n+1][n+1];
        for(int i = 0; i < results.length; i++){
            player[results[i][0]][results[i][1]] = 1;
            player[results[i][1]][results[i][0]] = -1;
        }
        
        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < n + 1; j++){
                for(int k = 1; k < n + 1; k++){
                    if(player[k][i] == 1 && player[i][j] == 1){
                        player[k][j] = 1;
                        player[j][k] = -1;
                    }
                }
            }
        }
        
        for(int i = 1; i < n + 1; i++){
            int count = 0;
            for(int j = 1; j < n + 1; j++)
                if(player[j][i] != 0) count++;
            if(count == n - 1) answer++;
        }
        
        return answer;
    }
}