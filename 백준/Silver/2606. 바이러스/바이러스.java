import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int K = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        A = new ArrayList[K + 1];
        visited = new boolean[K + 1];
        count = -1;

        for(int i = 1; i <= K; i++)
            A[i] = new ArrayList<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);
            A[e].add(s);
        }

        DFS(1);

        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void DFS(int node){
        count++;
        visited[node] = true;
        for(int i : A[node]){
            if(!visited[i]) DFS(i);
        }
    }
}