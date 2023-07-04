class Solution {
    public int solution(int num) {
        int answer = 0;
        long longNum = num;
        
        while(longNum != 1){
            longNum = longNum % 2 == 0 ? Long.valueOf(longNum / 2) : (longNum * 3) + 1;
            answer++;
            if(answer == 500){
                answer = -1;
                break;
            }
        }
        
        return answer;
    }
}