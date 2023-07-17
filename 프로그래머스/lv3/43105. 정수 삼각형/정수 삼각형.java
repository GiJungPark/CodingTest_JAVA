//하단에서부터 둘중에 큰놈을 위 값에 더함
//결국 끝까지 올라오면 [0][0]에는 이동방향에서 가장 큰 값을 확인할 수 있음.

class Solution {
    public int solution(int[][] triangle) {
        int size = triangle.length - 1;
        for(int i = size; i > 0; i--){
            for(int n = 0; n < triangle[i].length - 1; n++){
                int one = triangle[i][n];
                int two = triangle[i][n + 1];
                triangle[i - 1][n] += one > two ? one : two;
            }
        }
        
        int answer = triangle[0][0];
        return answer;
    }
}