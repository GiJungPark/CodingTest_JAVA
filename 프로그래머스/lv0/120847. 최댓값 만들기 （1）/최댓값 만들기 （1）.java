class Solution {
    public int solution(int[] numbers) {
        int size = numbers.length;
        for(int i = 0; i < size - 1; i++){
            int step = 0;
            for(int n = i + 1; n < size; n++){
                if(numbers[i] > numbers[n]){
                    step = numbers[i];
                    numbers[i] = numbers[n];
                    numbers[n] = step;
                }
            }
        }
        int answer = numbers[size - 1] * numbers[size - 2];
        return answer;
    }
}