import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        
        int par_size = participant.length;
        int com_size = completion.length;
        
        for(int i = 0; i < par_size; i++){
            if(map.get(participant[i]) == null){
                map.put(participant[i], 1);
            }else{
                map.put(participant[i], map.get(participant[i]) + 1);
            }
        }
        
        for(int i = 0; i < com_size; i++){
            if(map.get(completion[i]) > 1){
                map.put(completion[i], map.get(completion[i]) - 1);
            }else{
                map.remove(completion[i]);
            }
        }
        for(String i : map.keySet()){
            answer = i;
        }
        return answer;
    }
}