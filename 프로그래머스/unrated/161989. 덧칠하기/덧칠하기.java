class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        
        //벽 생성
        boolean[] arr = new boolean[n + 1];
        for(int i = 1; i < n + 1; i++)
            arr[i] = true;
        
        //색칠해야 하는 벽 구분
        for(int i : section)
            arr[i] = false;
        
        //색칙해야 하는 벽을 true로 변경한다.
        //롤러의 크기 만큼 다음 칸으로 이동하고,
        //롤러의 크기가 최대 범위를 벗어나면 최대 범위까지 색칠
        int start = 1;
        while(start < n + 1){
            if(arr[start] == false){
                answer++;
                if(start + m < n + 1){
                    for(int i = start; i < start + m; i++)
                        arr[i] = true;
                    start += m;
                }else{
                    for(int i = start; i < n + 1; i++)
                        arr[i] = true;
                    start += n + 1;
                }
            }else{
                start++;
            }
        }
        
        return answer;
    }
}