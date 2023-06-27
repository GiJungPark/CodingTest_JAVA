class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        
        double first = (double)(dots[0][1] - dots[1][1])
            / (dots[0][0] - dots[1][0]);
        double two = (double)(dots[2][1] - dots[3][1]) 
            / (dots[2][0] - dots[3][0]);
        if(first == two) answer = 1;
        
        double three = (double)(dots[0][1] - dots[2][1]) 
            / (dots[0][0] - dots[2][0]);
        double four = (double)(dots[1][1] - dots[3][1]) 
            / (dots[1][0] - dots[3][0]);
        if(three == four) answer = 1;
        
        double five = (double)(dots[0][1] - dots[3][1]) 
            / (dots[0][0] - dots[3][0]);
        double six = (double)(dots[2][1] - dots[1][1]) 
            / (dots[2][0] - dots[1][0]);
        if(five == six) answer = 1;
        
        return answer;
    }
}