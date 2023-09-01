import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int N, M;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 가로 길이
            N = Integer.parseInt(st.nextToken()); // 세로 길이
            int K = Integer.parseInt(st.nextToken()); // 심어진 배추의 개수

            map = new int[N][M];
            visited = new boolean[N][M];
            int count = 0;

            for(int j = 0; j < K; j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }

            for(int n = 0; n < N; n++){
                for(int m = 0; m < M; m++){
                    if(!visited[n][m] && map[n][m] == 1) {
                        visited[n][m] = true;
                        bfs(n, m);
                        count++;
                    }
                }
            }

            bw.write(count + "\n");
        }



        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int y, int x) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(x, y));
        while(!queue.isEmpty()){
            Pair poll = queue.poll();
            int now_x = poll.x;
            int now_y = poll.y;
            for(int i = 0; i < 4; i++){
                int next_x = now_x + dx[i];
                int next_y = now_y + dy[i];
                if(next_x < 0 || next_y < 0 || next_x >= M || next_y >= N)
                    continue;
                if(visited[next_y][next_x] || map[next_y][next_x] == 0)
                    continue;

                visited[next_y][next_x] = true;
                queue.offer(new Pair(next_x, next_y));
            }
        }
    }
}

class Pair {
    int x, y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}