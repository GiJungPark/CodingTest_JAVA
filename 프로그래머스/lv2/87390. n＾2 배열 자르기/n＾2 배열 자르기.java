class Solution {
    public int[] solution(int n, long left, long right) {
        int size = (int)(right - left) + 1;
        int[] answer = new int[size];
        
        for(int i = 0; i < size; i++){
            int num1 = (int)(left / n) + 1;
            int num2 = (int)(left % n) + 1;
            answer[i] = num1 > num2 ? num1 : num2; 
            left++;
        }
        
        return answer;
    }
}