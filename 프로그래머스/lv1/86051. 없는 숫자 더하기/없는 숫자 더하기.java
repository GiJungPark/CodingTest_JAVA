class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        String str = "0123456789";
        for(int i = 0; i < numbers.length; i++){
            str = str.replace(numbers[i] + "", "");
        }
        String[] arr = str.split("");
        for(int i = 0; i < arr.length; i++){
            answer += Integer.valueOf(arr[i]);
        }
        return answer;
    }
}