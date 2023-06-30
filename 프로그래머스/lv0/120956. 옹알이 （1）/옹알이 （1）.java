import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] stepArr = {"aya", "ye", "woo", "ma"};
        List<String> stepList = new ArrayList<>();
        
        for(int i = 0; i < 4; i++){
            List<String> step1 = new ArrayList<>(Arrays.asList(stepArr));
            String str1 = step1.remove(i);
            stepList.add(str1);
            for(int n = 0; n < 3; n++){
                List<String> step2 = new ArrayList<>(step1);
                String str2 = str1 + step2.remove(n);
                stepList.add(str2);
                for(int k = 0; k < 2; k++){
                    List<String> step3 = new ArrayList<>(step2);
                    String str3 = str2 + step3.remove(k);
                    stepList.add(str3);
                    for(int j = 0; j < 1; j++){
                        List<String> step4 = new ArrayList<>(step3);
                        String str4 = str3 + step4.remove(j);
                        stepList.add(str4);  
                    }
                }
            }
        }
        
        for(int i = 0; i < stepList.size(); i++){
            for(int n = 0; n < babbling.length; n++){
                if(stepList.get(i).equals(babbling[n])) answer++;
            }
        }
        
        return answer;
    }
}