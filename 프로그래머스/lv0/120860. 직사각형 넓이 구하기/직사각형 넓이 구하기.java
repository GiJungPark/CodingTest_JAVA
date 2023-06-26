class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        int width = 0;
        int height = 0;
        
        for(int i = 0; i < 3; i++){
            int dots_width1 = dots[i][0];
            int dots_width2 = dots[i + 1][0];
            int dots_height1 = dots[i][1];
            int dots_height2 = dots[i + 1][1];
            
            if(dots_width1 != dots_width2)
                width = Math.abs(dots_width2 - dots_width1);
            
            if(dots_height1 != dots_height2)
                height = Math.abs(dots_height2 - dots_height1);
        }
        answer = width * height;
        
        return answer;
    }
}