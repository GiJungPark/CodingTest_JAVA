class Solution {
    public int solution(String my_string) {
        int answer = 0;
        int strSize = my_string.length();
        String str = "";
        for(int i = 0; i < strSize; i++){
            char step = my_string.charAt(i);
            if('0' <= step && step <= '9'){
                str += step;
            } else if(!str.equals("")) {
                answer += Integer.valueOf(str);
                str = "";
            }
        }
        if(!str.equals("")) answer += Integer.valueOf(str);
        return answer;
    }
}