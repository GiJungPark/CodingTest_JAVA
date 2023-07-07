class Solution {
    public String solution(String s) {
        //문자열을 전부 소문자로 변경
        s = s.toLowerCase();
        
        String answer = "";

        int size = s.length();
        char oldStep = ' ';
        for(int i = 0; i < size; i++){
            char step = s.charAt(i);
            //첫 문자인 경우
            if(oldStep == ' ' && step != ' '){
                if('0' <= step && step <= '9'){
                    answer += step;
                }else{
                    answer += (char)(step - 32);
                }
            }else if(step == ' '){   //공백인 경우
                answer += " ";
            }else{                  //첫 문자와 공백 둘 다 아닌 경우
                answer += step;
            }
            
            oldStep = step;
        }
        return answer;
    }
}