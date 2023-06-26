class Solution {
    public int solution(int[] numbers) {
        int answer = -100000000;
        int numSize = numbers.length;
        for(int i = 0; i < numSize - 1; i++){
            for(int n = i + 1; n < numSize; n++){
                int step = numbers[i] * numbers[n];
                if(step > answer) answer = step;
            }
        }
        return answer;
    }
}