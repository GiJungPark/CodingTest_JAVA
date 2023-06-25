import java.util.Arrays;

class Solution {
    public String solution(String my_string) {
        String answer = "";
        
        char[] char_list = my_string.toCharArray();
        int list_size = char_list.length;
        
        for(int i = 0; i < list_size; i++){
            if(char_list[i] < 'a'){
                char_list[i] = (char)(char_list[i] + 32);
            }
        }
        
        Arrays.sort(char_list);
        
        for(int i = 0; i < list_size; i++){
            answer += char_list[i];
        }
        
        return answer;
    }
}