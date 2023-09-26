import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static int[] parent;
    static PriorityQueue<pEdge> queue;

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        queue = new PriorityQueue<>();
        parent = new int[N + 1];
        for(int i = 0; i < N; i++){
            parent[i] = i;
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            queue.add(new pEdge(start, end, value));
        }
        
        int useEdge = 0;
        int result = 0;
        while(useEdge < N - 1){
            pEdge now = queue.poll();
            if(find(now.start) != find(now.end)) {
                union(now.start, now.end);
                result = result + now.value;
                useEdge++;
            }
        }
        
        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b){
            parent[b] = a;
        }
    }
    public static int find(int a){
        if(a == parent[a])
            return a;
        else
            return parent[a] = find(parent[a]);
    }
}

class pEdge implements Comparable<pEdge> {
    int start;
    int end;
    int value;

    pEdge(int start, int end, int value){
        this.start = start;
        this.end = end;
        this.value = value;
    }

    @Override
    public int compareTo(pEdge o) {
        return this.value - o.value;
    }
}
