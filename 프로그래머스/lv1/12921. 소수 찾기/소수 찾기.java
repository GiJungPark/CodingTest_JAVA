// 첫번째 시도, 이중 for문으로 소수인지 각각 판별 => 시간 초과
// 에라토스테네스의 체 알고리즘 사용
class Solution {
    public int solution(int n) {
        int answer = 0;
        
        //숫자 n까지의 배열 생성
        int[] arr = new int[n + 1];
        for(int i = 2; i < n + 1; i++)
            arr[i] = i;
        
        //숫자가 남아있다면 소수이기 때문에 결과에 더함
        //이후 해당 소수의 배수를 지움 
        for(int i = 2; i <= n; i++){
            if(arr[i] != 0) answer++;
            
            for(int k = 1; i*k <= n; k++)
                arr[i*k] = 0;
        }
        return answer;
    }
}