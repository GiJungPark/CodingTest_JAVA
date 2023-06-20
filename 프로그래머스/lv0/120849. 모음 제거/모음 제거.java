class Solution {
    public String solution(String my_string) {
        String answer = "";
        int size = my_string.length();
        for(int i = 0; i < size; i++){
            String step = my_string.charAt(i) + "";
            if(!"aeiou".contains(step))
                answer += step;
        }
        return answer;
    }
}