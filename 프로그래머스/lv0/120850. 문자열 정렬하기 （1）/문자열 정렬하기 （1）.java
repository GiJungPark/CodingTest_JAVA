import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        List<Integer> list = new ArrayList<>();
        String ex = "0123456789";
        int size = my_string.length();
        for(int i = 0; i < size; i++){
            char step = my_string.charAt(i);
            if(ex.contains(step + ""))
                list.add(step - '0');
        }
        
        Collections.sort(list);
        
        int listSize = list.size();
        int[] answer = new int[listSize];
        for(int i = 0; i < listSize; i++){
            answer[i] = list.get(i).intValue();
        }
        
        return answer;
    }
}