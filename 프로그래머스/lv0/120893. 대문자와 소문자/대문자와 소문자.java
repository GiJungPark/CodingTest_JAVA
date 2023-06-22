class Solution {
    public String solution(String my_string) {
        String answer = "";
        int size = my_string.length();
        for(int i = 0; i < size; i++){
            char step = my_string.charAt(i);
            if('A' <= step && step <= 'Z'){
                answer += (char)(step + 32) + "";
            } else {
                answer += (char)(step - 32) + "";
            }
        }
        return answer;
    }
}