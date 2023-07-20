import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            char step = s.charAt(i);
            if(map.containsKey(step)){
                list.add(i - map.get(step));
                map.put(step, i);
            }else{
                map.put(step, i);   
                list.add(-1);
            }
        }
        
        int size = list.size();
        int[] answer = new int[size];
        for(int i = 0; i < size; i++){
            answer[i] = list.get(i).intValue();
        }
        return answer;
    }
}