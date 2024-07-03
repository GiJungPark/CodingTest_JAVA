import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Main {

    private static int N;
    private static int[][] map;
    private static int[][] result;
    private static boolean[][] visited;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;


    public static void main(String[] args) throws IOException {

        N = parseInt(br.readLine());
        int count = 1;

        while (N != 0) {
            run(count);
            count++;
            N = parseInt(br.readLine());
        }

        bw.flush();
        bw.close();

    }

    public static void run(int idx) throws IOException {

        map = new int[N][N];
        result = new int[N][N];
        visited = new boolean[N][N];


        for (int[] row : result) {
            Arrays.fill(row, 200_000);
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = parseInt(st.nextToken());
            }
        }

        bfs();

        sb = new StringBuilder("Problem ").append(idx).append(": ").append(result[N - 1][N - 1]).append("\n");
        bw.write(sb.toString());
    }

    public static void bfs() {
        PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(pair -> pair.cost));
        result[0][0] = map[0][0];
        queue.add(new Pair(0, 0, map[0][0]));

        while (!queue.isEmpty()) {
            Pair current = queue.poll();

            if (visited[current.y][current.x]) {
                continue;
            }

            visited[current.y][current.x] = true;

            for (int i = 0; i < 4; i++) {
                int nextx = current.x + dx[i];
                int nexty = current.y + dy[i];

                if (nextx < 0 || nexty < 0 || nextx >= N || nexty >= N) {
                    continue;
                }

                if (result[nexty][nextx] > result[current.y][current.x] + map[nexty][nextx]) {
                    result[nexty][nextx] = result[current.y][current.x] + map[nexty][nextx];
                    queue.add(new Pair(nextx, nexty, result[nexty][nextx]));
                }
            }

        }
    }

    static class Pair {
        int x, y, cost;

        Pair(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}