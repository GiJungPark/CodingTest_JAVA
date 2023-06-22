class Solution {
    public String solution(String my_string, int num1, int num2) {
        String answer = "";
        String str1 = my_string.charAt(num1)+"";
        String str2 = my_string.charAt(num2)+"";
        int size = my_string.length();
        for(int i = 0; i < size; i++){
            if(i == num1){
                answer += str2;
            }else if(i == num2){
                answer +=str1;
            }else{
                answer += my_string.charAt(i);
            }
        }
        return answer;
    }
}