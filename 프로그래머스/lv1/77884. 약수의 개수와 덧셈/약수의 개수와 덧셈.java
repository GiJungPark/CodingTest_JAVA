class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i = left; i <= right; i++){
            int count = 0;
            for(int n = 1; n <= i; n++)
                if(i % n == 0) count++;
            if(count % 2 == 0){
                answer += i;
            }else{
                answer -= i;
            }
        }
        return answer;
    }
}