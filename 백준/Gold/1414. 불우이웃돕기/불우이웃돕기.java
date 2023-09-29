import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    static int N, sum;
    static PriorityQueue<Edge> queue;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        queue = new PriorityQueue<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            char[] tmpC = st.nextToken().toCharArray();
            for(int j = 0; j < N; j++){
                int tmp = 0;
                if('a' <= tmpC[j] && tmpC[j] <= 'z')
                    tmp = tmpC[j] - 'a' + 1;
                if('A' <= tmpC[j] && tmpC[j] <= 'Z')
                    tmp = tmpC[j] - 'A' + 27;
                sum += tmp;
                if(i != j && tmp != 0) queue.add(new Edge(i, j, tmp));
            }
        }

        parent = new int[N];
        for(int i = 0; i < N; i++) parent[i] = i;
        int useEdge = 0;
        int result = 0;
        while(!queue.isEmpty()) {
            Edge now = queue.poll();
            if(find(now.start) != find(now.end)) {
                union(now.start, now.end);
                result += now.value;
                useEdge++;
            }
        }

        if(useEdge == N - 1) bw.write(sum - result + "\n");
        else bw.write(-1 + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b) parent[b] = a;
    }

    public static int find(int a) {
        if (a == parent[a]) return a;
        else return parent[a] = find(parent[a]);
    }
}

class Edge implements Comparable<Edge>{
    int start;
    int end;
    int value;
    Edge(int start, int end, int value) {
        this.start = start;
        this.end = end;
        this.value = value;
    }
    @Override
    public int compareTo(Edge o){
        return this.value - o.value;
    }
}
