class Solution {
    public int solution(int n) {
        int answer = 0;
        int size = Integer.bitCount(n);
        while(true){
            if(size == Integer.bitCount(++n)){
                answer = n;
                break;
            }
        }
        
        return answer;
    }
}