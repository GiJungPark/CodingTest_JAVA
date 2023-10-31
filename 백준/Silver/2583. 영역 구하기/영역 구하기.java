import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] visited;
    static Queue<Pair> queue = new LinkedList<>();
    static List<Integer> list = new ArrayList<>();

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int N;
    static int M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 세로
        N = Integer.parseInt(st.nextToken()); // 가로
        int K = Integer.parseInt(st.nextToken()); // 개수

        visited = new boolean[M][N];

        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x_start = Integer.parseInt(st.nextToken());
            int y_start = Integer.parseInt(st.nextToken());
            int x_end = Integer.parseInt(st.nextToken());
            int y_end = Integer.parseInt(st.nextToken());

            for(int y = y_start; y < y_end; y++) {
                for (int x = x_start; x < x_end; x++) {
                    visited[y][x] = true;
                }
            }

        }

        for(int y = 0; y < M; y++) {
            for (int x = 0; x < N; x++) {
                if(!visited[y][x]) {
                    queue.add(new Pair(x, y));
                    list.add(BFS());
                }
            }
        }

        Collections.sort(list);

        bw.write(list.size() + "\n");
        for(int i = 0; i < list.size(); i++){
            bw.write(list.get(i) + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static int BFS() {
        int range = 1;

        while(!queue.isEmpty()) {
            Pair pair = queue.poll();
            int x = pair.x;
            int y = pair.y;

            visited[y][x] = true;
            for (int i = 0; i < 4; i++) {
                int next_x = x + dx[i];
                int next_y = y + dy[i];

                if(next_x < 0 || next_y < 0 || next_x >= N || next_y >= M)
                    continue;

                if(!visited[next_y][next_x]){
                    visited[next_y][next_x] = true;
                    queue.add(new Pair(next_x, next_y));
                    range++;
                }

            }
        }

        return range;
    }

}

class Pair {
    int x;
    int y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}