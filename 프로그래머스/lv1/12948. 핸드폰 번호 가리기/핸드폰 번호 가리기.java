class Solution {
    public String solution(String phone_number) {
        String answer = "";
        int size = phone_number.length() - 4;
        for(int i = 0; i < size; i++){
            answer += "*";
        }
        for(int i = size; i < size + 4; i++){
            answer += phone_number.charAt(i);
        }
        return answer;
    }
}