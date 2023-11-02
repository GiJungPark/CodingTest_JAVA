import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); // 세로

        visited = new boolean[N][N];
        map = new int[N][N];

        int max = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
            }
        }

        int result = 1;
        for (int i = 0; i <= max; i++) {
            int cnt = 0;
            visited = new boolean[N][N];
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    if (map[y][x] > i && !visited[y][x]) {
                        cnt++;
                        BFS(x, y, i);
                    }
                }
            }
            result = Math.max(result, cnt);
        }

        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void BFS(int x, int y, int height) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int next_x = x + dx[i];
            int next_y = y + dy[i];

            if (next_x < 0 || next_y < 0 || next_x >= N || next_y >= N) continue;

            if (map[next_y][next_x] <= height || visited[next_y][next_x]) continue;

            BFS(next_x, next_y, height);
        }
    }

}