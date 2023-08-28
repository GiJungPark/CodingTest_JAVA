import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int K;
    static int[] dx = {-1, 1, 0};
    static int[] map = new int[100001];
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(N == K) {
            bw.write(0 + "\n");
        } else {
            bfs(N);
            bw.write(map[K] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void bfs(int x){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        visited[x] = true;
        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int i = 0; i < 3; i++){
                int next;
                if(dx[i] == 0) {
                    next = now * 2;
                } else {
                    next = now + dx[i];
                }

                if(next < 0 || next > 100000 || visited[next])
                    continue;
                queue.offer(next);
                visited[next] = true;
                map[next] = map[now] + 1;

                if(map[K] != 0){
                    return;
                }
            }
        }
    }
}