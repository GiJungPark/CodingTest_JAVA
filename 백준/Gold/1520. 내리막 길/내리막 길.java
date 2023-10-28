import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int M;

    private static int[][] arr;
    private static int[][] dp;

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 세로의 크기 M, 가로의 크기 N;
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[M + 1][N + 1];
        dp = new int[M + 1][N + 1];

        for(int m = 1; m <= M; m++) {
            st = new StringTokenizer(br.readLine());
            for(int n = 1; n <= N; n++) {
                arr[m][n] = Integer.parseInt(st.nextToken());
                dp[m][n] = -1;
            }
        }

        bw.write(BFS(1, 1) + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int BFS(int x, int y) {

        if(x == M && y == N) {
            return 1;
        }

        if(dp[x][y] != -1) {
            return dp[x][y];
        }

        dp[x][y] = 0;
        for(int i = 0; i < 4; i++) {
            int next_x = x + dx[i];
            int next_y = y + dy[i];

            if (next_x < 1 || next_y < 1 || next_x > M || next_y > N)
                continue;
            if (arr[x][y] <= arr[next_x][next_y])
                continue;
            dp[x][y] += BFS(next_x, next_y);
        }

        return dp[x][y];
    }

}