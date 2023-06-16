class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] fac = new int[10];
        
        for(int i = 1; i <= 10; i++){
            fac[i - 1] = op(i);
        }
        
        for(int i = 0; i < 10; i++){
            if(fac[i] <= n) answer = i + 1;
        }
        
        return answer;
    }
    
    public int op (int n){
        if(n == 1) return 1;
        return n * op(n - 1);
    }
}