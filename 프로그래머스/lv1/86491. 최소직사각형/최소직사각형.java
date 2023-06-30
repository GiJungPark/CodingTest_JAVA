class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int widthMax = 0;
        int heightMax = 0;
        
        for(int i = 0; i < sizes.length; i++){
            int num1 = sizes[i][0];
            int num2 = sizes[i][1];
            if(num1 < num2){
                int step = num2;
                num2 = num1;
                num1 = step;
            }
            if(widthMax < num1) widthMax = num1;
            if(heightMax < num2) heightMax = num2;
        }
        
        answer = widthMax * heightMax;
        return answer;
    }
}