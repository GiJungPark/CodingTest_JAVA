import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static boolean[] visited;
    static int[] distance;
    static ArrayList<Edge>[] list;
    static PriorityQueue<Edge> queue = new PriorityQueue<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); // 도시 개수
        M = Integer.parseInt(br.readLine()); // 버스 개수

        visited = new boolean[N + 1];
        distance = new int[N + 1];
        list = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++){
            list[i] = new ArrayList<>();
        }
        for(int i = 0; i <= N; i++){
            distance[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int startNode = Integer.parseInt(st.nextToken());
            int endNode = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            list[startNode].add(new Edge(endNode, value));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        queue.add(new Edge(start, 0));
        distance[start] = 0;
        while(!queue.isEmpty()){
            Edge poll = queue.poll();
            int node = poll.node;
            if(visited[node]) continue;
            visited[node] = true;
            for(int i = 0; i < list[node].size(); i++){
                Edge tmp = list[node].get(i);
                int next = tmp.node;
                int value = tmp.value;
                if(distance[next] > distance[node] + value){
                    distance[next] = distance[node] + value;
                    queue.add(new Edge(next, distance[next]));
                }
            }
        }

        bw.write(distance[end] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

class Edge implements Comparable<Edge>{
    int node;
    int value;
    Edge(int node, int value){
        this.node = node;
        this.value = value;
    }

    @Override
    public int compareTo(Edge o){
        if(this.value > o.value) return 1;
        else return -1;
    }
}