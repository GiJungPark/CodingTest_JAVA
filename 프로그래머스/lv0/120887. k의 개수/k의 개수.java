class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        for(int n = i; n <= j; n++){
            String[] strArr = String.valueOf(n).split("");
            for(String str : strArr){
                if(str.equals(String.valueOf(k)))
                    answer++;
            }
        }
        return answer;
    }
}