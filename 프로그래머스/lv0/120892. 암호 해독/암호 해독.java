class Solution {
    public String solution(String cipher, int code) {
        String answer = "";
        int size = cipher.length();
        for(int i = code - 1; i < size; i += code){
            answer += cipher.charAt(i) + "";
        }
        return answer;
    }
}