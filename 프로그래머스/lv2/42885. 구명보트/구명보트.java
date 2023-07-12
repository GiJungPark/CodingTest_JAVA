import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int max = people.length - 1;
        int min = 0;
        while(true){
            if(limit >= people[max] + people[min]) 
                min++;
            
            answer++;
            max--;
            
            if(min >= max){
                if(min == max) answer++;
                break;
            }
        }
        return answer;
    }
}