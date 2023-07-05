class Solution {
    public String solution(String s, int n) {
        String answer = "";
        for(int i = 0; i < s.length(); i++){
            char step = s.charAt(i);
            int ch = step + n;
            if('a' <= step && step <= 'z'){
                if(ch <= 'z'){
                    answer += (char)ch;
                }else{
                    answer += (char)(ch - 26);
                }
            }else if('A' <= step && step <= 'Z'){
                if(ch <= 'Z'){
                    answer += (char)ch;
                }else{
                    answer += (char)(ch - 26);
                }
            }else{
                answer += " ";
            }
        }
        return answer;
    }
}