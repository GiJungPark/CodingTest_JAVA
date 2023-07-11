class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        
        String[] answer = new String[arr1.length];
        for(int i = 0; i < arr1.length; i++){
            String step = Integer.toBinaryString(arr1[i] | arr2[i]);
            //1. n크기에 맞는 2진수로 저장, 비는 부분은 0으로 채움
            //2. "1"은 "#"으로, "0"은 공백으로 변환
            answer[i] = " ".repeat(n - step.length()) + step;
            answer[i] = answer[i].replaceAll("1", "#");
            answer[i] = answer[i].replaceAll("0", " ");
        }
        return answer;
    }
}