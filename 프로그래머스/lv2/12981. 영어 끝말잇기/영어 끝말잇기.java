import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        int pNum = 0;
        int wNum = 0;
        set.add(words[0]);
        
        for(int i = 1; i < words.length; i++){
            String oldStep = words[i - 1];
            String step = words[i];
            if(oldStep.charAt(oldStep.length() - 1) != step.charAt(0) 
               || set.contains(step)){
                pNum = (i % n) + 1;
                wNum = (i / n) + 1;
                break;
            }
            set.add(step);
        }

        int[] answer = {pNum, wNum};
        return answer;
    }
}