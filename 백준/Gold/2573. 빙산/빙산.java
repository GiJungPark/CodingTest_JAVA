import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        int cnt = 0;
        
        while ((cnt = getCount()) < 2) {
            if (cnt == 0) {
                ans = 0;
                break;
            }

            bfs();
            ans++;
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int getCount() {
        boolean[][] visited = new boolean[N][M];

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    dfs(i, j, visited); 
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void dfs(int x, int y, boolean[][] visited) {
        visited[x][y] = true;

        int next_x, next_y;
        for (int i = 0; i < 4; i++) {
            next_x = x + dx[i];
            next_y = y + dy[i];

            if (next_x < 0 || next_y < 0 || next_x >= N || next_y >= M) {
                continue;
            }

            if (map[next_x][next_y] != 0 && !visited[next_x][next_y]) {
                dfs(next_x, next_y, visited);
            }
        }
    }
    
    public static void bfs() {
        Queue<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) {
                    q.offer(new Pair(i, j));
                    visited[i][j] = true;
                }
            }
        }

        int next_x, next_y;
        while (!q.isEmpty()) {
            Pair poll = q.poll();

            int seaNum = 0;

            for (int i = 0; i < 4; i++) {
                next_x = poll.x + dx[i];
                next_y = poll.y + dy[i];

                if (next_x < 0 || next_y < 0 || next_x >= N || next_y >= M) {
                    continue;
                }

                if (!visited[next_x][next_y] && map[next_x][next_y] == 0) {
                    seaNum++;
                }
            }

            if (map[poll.x][poll.y] - seaNum < 0) {
                map[poll.x][poll.y] = 0;
            } else {
                map[poll.x][poll.y] -= seaNum;
            }
        }
    }
}