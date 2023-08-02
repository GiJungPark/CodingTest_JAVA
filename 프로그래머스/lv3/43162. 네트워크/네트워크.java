import java.util.Stack;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < computers.length; i++){
            if(visited[i]) continue;
            st.push(i);
            answer++;
            
            while(!st.isEmpty()){
                int step = st.pop();
                if(visited[step]) continue;
                visited[step] = true;
                for(int j = 0; j < computers[step].length; j++){
                    if(visited[j] || computers[step][j] == 0) continue;
                    st.push(j);
                }
            }
        }
        return answer;
    }
}