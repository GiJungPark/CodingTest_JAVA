class Solution {
    public int[] solution(long n) {
        String str = n + "";
        int[] answer = new int[str.length()];
        int count = 0;
        for(int i = str.length() - 1; i >= 0; i--){
            answer[count++] = Integer.valueOf(str.charAt(i) - '0');
        }
        return answer;
    }
}