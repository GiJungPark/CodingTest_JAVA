class Solution {
    public String solution(String s) {
        String answer = "";
        int count = 0;
        int size = s.length();
        for(int i = 0; i < size; i++){
            char chr = s.charAt(i);
            if(chr == ' '){
                answer += " ";
                count = 0;
            }else{
                answer += count++ % 2 == 0 ? 
                    Character.toUpperCase(chr) : Character.toLowerCase(chr);    
            }
        }
        return answer;
    }
}