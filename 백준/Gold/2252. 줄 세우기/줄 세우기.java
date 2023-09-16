import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 위상정렬
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 학생의 수
        int M = Integer.parseInt(st.nextToken()); // 비교 횟수
        
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            A.add(new ArrayList<>());
        }

        int[] indegree = new int[N + 1]; // 진입 차수 배열
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            A.get(S).add(E);
            indegree[E]++; // 진입 차수 데이터 저장
        }
        
        // 위상 정렬 수행
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= N; i++){
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            int now = queue.poll();
            bw.write(now + " ");
            for(int next : A.get(now)) {
                indegree[next]--;
                if(indegree[next] == 0){
                    queue.offer(next);
                }
            }
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}