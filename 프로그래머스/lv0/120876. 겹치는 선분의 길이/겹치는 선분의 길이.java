class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        //(-100 ~ 100) + 100 => 0 ~ 200
        int[] arr = new int[201];
        
        for(int i = 0; i < 3; i++){
            for(int n = lines[i][0]; n <= lines[i][1]; n++){
                arr[n + 100] += 1;
            }
        }
        
        for(int i = 0; i < 200; i++){
            if(arr[i] >= 2 && arr[i + 1] >= 2) answer++;
        }
        
        if(lines[0][1] - lines[0][0] == 1 && 
           lines[1][1] - lines[1][0] == 1 && 
           lines[2][1] - lines[2][0] == 1)
            answer = 0;
        
        return answer;
    }
}