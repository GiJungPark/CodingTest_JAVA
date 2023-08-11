import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] map;
    static boolean[][] visited;
    static int N;
    static int M;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for(int j = 0; j < N; j++){
            String step = br.readLine();
            for(int k = 0; k < M; k++){
                map[j][k] = step.charAt(k) - '0';
            }
        }

        visited[0][0] = true;
        BFS(0, 0);
        System.out.println(map[N-1][M-1]);
    }

    static void BFS(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int now_x = now[0];
            int now_y = now[1];
            for (int i = 0; i < 4; i++) {
                int next_x = now_x + dx[i];
                int next_y = now_y + dy[i];
                if(next_x < 0 || next_y < 0 || next_x >= N || next_y >= M)
                    continue;
                if(visited[next_x][next_y] || map[next_x][next_y] == 0)
                    continue;

                queue.offer(new int[] {next_x,next_y});
                map[next_x][next_y] = map[now_x][now_y] + 1;
                visited[next_x][next_y] = true;
            }
        }
    }
}