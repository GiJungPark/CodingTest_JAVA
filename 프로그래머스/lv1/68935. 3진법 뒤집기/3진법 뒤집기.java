class Solution {
    public int solution(int n) {
        int answer = 0;
        String str = Integer.toString(n, 3);
        int size = str.length();
        for(int i = 0; i < size; i++){
            int step = str.charAt(i) - '0';
            answer += step * (int)Math.pow(3, i);
        }
        return answer;
    }
}