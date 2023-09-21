import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int[][] W = new int[1001][1001];
    static PriorityQueue<Integer>[] distanceQueue;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 도시 개수
        M = Integer.parseInt(st.nextToken()); // 도로 개수
        K = Integer.parseInt(st.nextToken()); // k번째 최단 경로
        distanceQueue = new PriorityQueue[N + 1];
        
        // 정렬 기준 내림차순
        Comparator<Integer> cp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 < o2 ? 1: -1;
            }
        };
        
        for(int i = 1; i <= N; i++){
            distanceQueue[i] = new PriorityQueue<>(K, cp);
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int startNode = Integer.parseInt(st.nextToken());
            int endNode = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            W[startNode][endNode] = value;
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(1, 0));
        distanceQueue[1].add(0);

        while(!pq.isEmpty()){
            Edge poll = pq.poll();
            for(int i = 1; i <= N; i++){
                if(W[poll.node][i] != 0){
                    int tmp = poll.value + W[poll.node][i];
                    if(distanceQueue[i].size() < K){
                        distanceQueue[i].add(tmp);
                        pq.add(new Edge(i, tmp));
                    }else if(distanceQueue[i].peek() > tmp){
                        distanceQueue[i].poll();
                        distanceQueue[i].add(tmp);
                        pq.add(new Edge(i, tmp));
                    }
                }
            }
        }

        for(int i = 1; i <= N; i++){
            if(distanceQueue[i].size() == K) {
                bw.write(distanceQueue[i].peek() + "\n");
            } else {
                bw.write(-1 + "\n");
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
        return this.value > o.value ? 1 : -1;
    }
}