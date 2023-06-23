class Solution {
    public int solution(int num, int k) {
        int answer = 0;
        int step = 0;
        int count = 1;
        
        while(num > 0){
            if(num % 10 == k) step = count;
            num = num / 10;
            count++;
        }
        
        answer = step == 0 ? -1 : count - step;
        return answer;
    }
}