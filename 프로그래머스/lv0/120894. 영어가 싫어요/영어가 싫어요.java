import java.util.*;

class Solution {
    public long solution(String numbers) {
        List <String> list = new ArrayList<>();
        int size = numbers.length();
        String step = "";
        String answer = "";
        String[] number_list = {"zero", "one", "two", "three", "four", "five", 
                                "six", "seven", "eight", "nine"};
        for(int i = 0; i < size; i++){
            step += numbers.charAt(i) + "";
            for(int n = 0; n < 10; n++){
                if(step.equals(number_list[n])){
                    step = "";
                    answer += n;
                }   
            }
        }
        
        size = answer.length();
        long real_answer = 0;
        int count = 0;
        for(int i = size - 1; i >= 0; i--){
            real_answer += (long)(answer.charAt(i) - '0') * (long)Math.pow(10, count++);
        }
        return real_answer;
    }
}