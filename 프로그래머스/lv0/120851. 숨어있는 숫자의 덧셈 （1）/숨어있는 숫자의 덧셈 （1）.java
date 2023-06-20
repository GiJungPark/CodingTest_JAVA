class Solution {
    public int solution(String my_string) {
        int answer = 0;
        int size = my_string.length();
        for(int i = 0; i < size; i++){
            char step = my_string.charAt(i);
            if('0' <= step && step <= '9')
                answer += step - '0';
        }
        return answer;
    }
}