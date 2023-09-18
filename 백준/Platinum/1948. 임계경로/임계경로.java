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

        int N = Integer.parseInt(br.readLine()); // 도시의 수
        int M = Integer.parseInt(br.readLine()); // 도로의 수
        ArrayList<ArrayList<node>> A = new ArrayList<>();
        ArrayList<ArrayList<node>> reverseA = new ArrayList<>();

        for(int i = 0; i <= N; i++){
            A.add(new ArrayList<>());
            reverseA.add(new ArrayList<>());
        }

        int[] indegree = new int[N + 1]; // 진입 차수 배열
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            A.get(S).add(new node(E, V));
            reverseA.get(E).add(new node(S, V));
            indegree[E]++;
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        // 위상 정렬 수행
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        int[] result = new int[N + 1];
        while(!queue.isEmpty()){
            int now = queue.poll();
            for(node next : A.get(now)) {
                indegree[next.targetNode]--;
                result[next.targetNode] = Math.max(result[next.targetNode], result[now] + next.value);
                if(indegree[next.targetNode] == 0){
                    queue.offer(next.targetNode);
                }
            }
        }

        int resultCnt = 0;
        queue = new LinkedList<>();
        queue.offer(end);
        boolean[] visited = new boolean[N + 1];
        visited[end] = true;
        while(!queue.isEmpty()){
            int now = queue.poll();
            for(node next : reverseA.get(now)) {
                if(result[next.targetNode] + next.value == result[now]){
                    resultCnt++;
                    if(!visited[next.targetNode]){
                        visited[next.targetNode] = true;
                        queue.offer(next.targetNode);
                    }
                }
            }
        }

        bw.write(result[end] + "\n");
        bw.write(resultCnt + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

class node{
    int targetNode;
    int value;
    node(int targetNode, int value){
        this.targetNode = targetNode;
        this.value = value;
    }
}