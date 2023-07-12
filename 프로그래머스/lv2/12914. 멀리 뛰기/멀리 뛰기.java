//3칸인 경우 = 3가지 방법
//4칸인 경우 = 5가지 방법
//5칸인 경우 = (11111)1가지 + (1112)4가지 + (122)3가지 => 8가지 방법
//피보나치 수열
class Solution {
    public long solution(int n) {
        long answer = 0;
        long[] arr = new long[n];
        if(n > 2){
            arr[0] = 1;
            arr[1] = 2;
            for(int i = 2; i < n; i++){
                arr[i] = (arr[i-2] + arr[i-1]) % 1234567;
            }
            answer = arr[n-1];
        }else{
            answer = n;
        }
        return answer;
    }
}