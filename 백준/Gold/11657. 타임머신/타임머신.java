import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static long distance[];
    static Edge[] edges;
    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        edges = new Edge[M + 1];
        distance = new long[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(start, end, time);
        }

        distance[1] = 0;
        for(int i = 1; i < N; i++){
            for(int j = 0; j < M; j++){
                Edge edge = edges[j];
                if(distance[edge.start] != Integer.MAX_VALUE
                        && distance[edge.end] > distance[edge.start] + edge.time){
                    distance[edge.end] = distance[edge.start] + edge.time;
                }
            }
        }

        boolean cycle = false;
        for(int i = 0; i < M; i++){
            Edge edge = edges[i];
            if(distance[edge.start] != Integer.MAX_VALUE
                    && distance[edge.end] > distance[edge.start] + edge.time){
                cycle = true;
            }
        }

        if(!cycle){
            for(int i = 2; i <= N; i++){
                if(distance[i] == Integer.MAX_VALUE)
                    bw.write(-1 + "\n");
                else
                    bw.write(distance[i] + "\n");
            }
        }else{
            bw.write(-1 + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

class Edge {
    int start;
    int end;
    int time;
    Edge(int start, int end, int time){
        this.start = start;
        this.end = end;
        this.time = time;
    }
}