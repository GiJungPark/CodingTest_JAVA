/*
1 ~ 5
6 ~ 30
31 ~ 155
156 ~ 780
781 ~ 3905
*/
class Solution {
    String WORD = "AEIOU";
    int[] number = {781, 156, 31, 6, 1};
    public int solution(String word) {
        int size = word.length();
        int answer = size;
        for(int i = 0; i < size; i++){
            answer += number[i] * (WORD.indexOf(word.charAt(i)));
        }
        return answer;
    }
}