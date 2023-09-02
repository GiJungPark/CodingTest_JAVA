import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {2, 2, 1, 1, -2, -2, -1, -1};
    static int[] dy = {1, -1, -2, 2, -1, 1, -2, 2};
    static boolean[][] visited;
    static int[][] map;
    static int N;
    static Pair destination;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            N = Integer.parseInt(br.readLine());
            visited = new boolean[N][N];
            map = new int[N][N];

            st = new StringTokenizer(br.readLine());
            Pair start = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            st = new StringTokenizer(br.readLine());
            destination = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            visited[start.x][start.y] = true;
            bfs(start);
            bw.write(map[destination.x][destination.y] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(Pair pair) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(pair);
        while(!queue.isEmpty()) {
            Pair poll = queue.poll();
            int now_x = poll.x;
            int now_y = poll.y;
            for (int d = 0; d < 8; d++) {
                int next_x = now_x + dx[d];
                int next_y = now_y + dy[d];
                if (next_x < 0 || next_y < 0 || next_x >= N || next_y >= N)
                    continue;
                if (visited[next_x][next_y] || map[next_x][next_y] != 0)
                    continue;

                queue.offer(new Pair(next_x, next_y));
                visited[next_x][next_y] = true;
                map[next_x][next_y] = map[now_x][now_y] + 1;

                if (next_x == destination.x && next_y == destination.y)
                    return;
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
