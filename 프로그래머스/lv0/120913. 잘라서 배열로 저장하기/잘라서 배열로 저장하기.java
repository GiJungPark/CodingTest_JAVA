import java.util.*;

class Solution {
    public String[] solution(String my_str, int n) {
        List<String> list = new ArrayList<>();
        int size = my_str.length();
        
        for(int i = 0; i < size; i += n){
            int last_index = i + n;
            if(size < i + n){
                last_index = size;
            }
            list.add(my_str.substring(i, last_index));
        }
        
        int list_size = list.size();
        String[] answer = list.toArray(new String[list_size]);
        
        return answer;
    }
}