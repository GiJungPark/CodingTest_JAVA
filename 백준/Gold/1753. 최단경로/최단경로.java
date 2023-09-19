import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int V, E, K;
    static boolean[] visited;
    static int[] distance;
    static ArrayList<Edge>[] list;
    static PriorityQueue<Edge> queue = new PriorityQueue<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        visited = new boolean[V + 1];
        distance = new int[V + 1];
        list = new ArrayList[V + 1];
        for(int i = 1; i <= V; i++){
            list[i] = new ArrayList<>();
        }
        for(int i = 0; i <= V; i++){
            distance[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int startNode = Integer.parseInt(st.nextToken());
            int endNode = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            list[startNode].add(new Edge(endNode, value));
        }

        queue.add(new Edge(K, 0));
        distance[K] = 0;
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

        for(int i = 1; i <= V; i++){
            if(visited[i]){
                bw.write(distance[i] + "\n");
            }else{
                bw.write("INF \n");
            }
        }

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