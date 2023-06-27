class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        int num1 = sides[0];
        int num2 = sides[1];
        int max = num1 > num2 ? num1 : num2;
        int min = num1 > num2 ? num2 : num1;
        answer = 2 * min - 1;
        return answer;
    }
}