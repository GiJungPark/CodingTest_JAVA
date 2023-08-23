import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] A;
    static int N, M;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new ArrayList[N + 1];
        answer = new int[N + 1];

        for(int i = 1; i <= N; i++)
            A[i] = new ArrayList<>();

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            A[S].add(E);
        }

        for(int i = 1; i <= N; i++){
            visited = new boolean[N + 1];
            bfs(i);
        }

        int maxVal = 0;
        for(int i = 1; i <= N; i++)
            maxVal = Math.max(maxVal, answer[i]);

        for(int i = 1; i <= N; i++){
            if(answer[i] == maxVal) System.out.print(i + " ");
        }
    }

    private static void bfs(int index) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(index);
        visited[index] = true;
        while (!queue.isEmpty()) {
            int now_node = queue.poll();
            for(int i : A[now_node]){
                if(visited[i] == false){
                    visited[i] = true;
                    answer[i]++;
                    queue.add(i);
                }
            }
        }
    }
}