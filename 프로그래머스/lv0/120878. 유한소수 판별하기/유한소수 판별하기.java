class Solution {
    public int solution(int a, int b) {
        int answer = 2;
        
        int max = a > b ? a : b;
        int min = a > b ? b : a;
        
        int gcd = opGCD(max, min);
        
        if(gcd != 1) b = b / gcd;
        
        while(b > 0){
            if(b % 2 == 0) b = b / 2;
            if(b % 5 == 0) b = b / 5;
            if(b == 1) answer = 1;
            if(b % 2 != 0 && b % 5 != 0) break;
        }
        
        return answer;
    }
    
    public int opGCD(int num1, int num2){
        if(num1 % num2 == 0){
            return num2;
        }
        return opGCD(num2, num1 % num2);
    }
}