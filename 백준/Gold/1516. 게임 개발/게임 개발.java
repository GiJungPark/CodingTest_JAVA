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
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 건물 종류 수
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            A.add(new ArrayList<>());
        }

        int[] indegree = new int[N + 1]; // 진입 차수 배열
        int[] selfBuild = new int[N + 1]; // 짓는데 걸리는 시간
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            selfBuild[i] = Integer.parseInt(st.nextToken());
            while(true){
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp == -1) break;
                A.get(tmp).add(i);
                indegree[i]++;
            }
        }

        // 위상 정렬 수행
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= N; i++){
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] result = new int[N + 1];
        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int next : A.get(now)) {
                indegree[next]--;
                result[next] = Math.max(result[next], result[now] + selfBuild[now]);
                if(indegree[next] == 0){
                    queue.offer(next);
                }
            }
        }
        
        for(int i = 1; i <= N; i++){
            bw.write(result[i] + selfBuild[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}