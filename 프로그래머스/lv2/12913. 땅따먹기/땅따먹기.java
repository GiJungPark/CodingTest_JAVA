class Solution {
    int solution(int[][] land) {
        int size = land.length;
        for(int i = 1; i < size; i++){
            land[i][0] += max(land[i-1][1], land[i-1][2], land[i-1][3]);
            land[i][1] += max(land[i-1][0], land[i-1][2], land[i-1][3]);
            land[i][2] += max(land[i-1][0], land[i-1][1], land[i-1][3]);
            land[i][3] += max(land[i-1][0], land[i-1][1], land[i-1][2]);
        }
        
        int last = size - 1;
        int answer = land[last][0];
        for(int i = 1; i < 4; i++){
            if(answer < land[last][i])
                answer = land[last][i];
        }
        
        return answer;
    }
    
    public int max(int num1, int num2, int num3){
        if(num1 > num2){
            if(num1 > num3){
                return num1;
            }else{
                return num3;
            }
        }else{
            if(num2 > num3){
                return num2;
            }else{
                return num3;
            }
        }
    }
}