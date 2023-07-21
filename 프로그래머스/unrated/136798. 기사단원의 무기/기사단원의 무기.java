class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;

        for(int i = 0; i < number; i++){
            int step = measure(i + 1);
            answer += step > limit ? power : step;
        }
        
        return answer;
    }
    
    //약수를 구하기를 최적화
    public int measure(int num){
        int count = 0;
        for(int i = 1; i * i <= num; i++){
            if(i * i == num){
                count++;
            }else if(num % i == 0){
                count += 2;
            }
        }
        return count;
    }
}