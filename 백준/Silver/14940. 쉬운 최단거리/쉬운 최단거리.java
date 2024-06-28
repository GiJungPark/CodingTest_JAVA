import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

// N: 세로, M: 가로
public class Main {

    private static int N, M, startX, startY;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = parseInt(st.nextToken());
        M = parseInt(st.nextToken());

        // 맵 초기화
        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int temp = parseInt(st.nextToken());
                if (temp == 2) {
                    startY = i;
                    startX = j;
                }

                if (temp == 0) {
                    visited[i][j] = true;
                }
            }
        }

        bfs();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    sb.append(-1).append(" ");
                } else {
                    sb.append(map[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }


        bw.write(sb.toString());
        

        bw.flush();
        bw.close();
    }

    public static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(startX, startY));

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (visited[current.y][current.x]) {
                continue;
            }

            visited[current.y][current.x] = true;

            for (int i = 0; i < 4; i++) {
                int nextX = dx[i] + current.x;
                int nextY = dy[i] + current.y;

                if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N || visited[nextY][nextX]) {
                    continue;
                }

                map[nextY][nextX] = map[current.y][current.x] + 1;
                queue.add(new Node(nextX, nextY));
            }

        }
    }

    public static class Node {

        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}