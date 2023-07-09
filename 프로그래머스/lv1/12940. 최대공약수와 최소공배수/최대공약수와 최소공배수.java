class Solution {
    public int[] solution(int n, int m) {
        int max = n > m ? n : m;
        int min = n < m ? n : m;
        int gcdNum = gcd(max, min);
        int[] answer = {gcdNum, (int)(n * m / gcdNum)};
        return answer;
    }
    
    private int gcd(int a, int b){
        
        return b == 0 ? a : gcd(b, a % b);
    }
}