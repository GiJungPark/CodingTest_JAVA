
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static boolean[][][] visited;
    static int[][][] map;
    static int M, N, H;
    static int count;
    static Queue<Tuple> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        count = 0;

        map = new int[H][N][M];
        visited = new boolean[H][N][M];

        boolean checkOne = true;
        for(int h = 0; h < H; h++){
            for(int n = 0; n < N; n++){
                st = new StringTokenizer(br.readLine());
                for(int m = 0; m < M; m++){
                    map[h][n][m] = Integer.parseInt(st.nextToken());
                    if(map[h][n][m] == 1){
                        visited[h][n][m] = true;
                        queue.offer(new Tuple(h, n, m));
                    }else if(map[h][n][m] == 0){
                        checkOne = false;
                    }
                }
            }
        }

        if(checkOne){
            bw.write(0 + "\n");
            bw.flush();
            bw.close();
            br.close();
            return;
        }

        bfs();

        int max = 0;
        boolean checkTwo = false;
        for(int h = 0; h < H; h++){
            for(int n = 0; n < N; n++){
                for(int m = 0; m < M; m++){
                    max = map[h][n][m] > max ? map[h][n][m] : max;
                    if(map[h][n][m] == 0) checkTwo = true;
                }
            }
        }

        if(checkTwo){
            bw.write(-1 + "\n");
        }else{
            bw.write((max -1) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs() {
        while(!queue.isEmpty()) {
            Tuple poll = queue.poll();
            int now_x = poll.x;
            int now_y = poll.y;
            int now_z = poll.z;
            for (int d = 0; d < 6; d++) {
                int next_x = now_x + dx[d];
                int next_y = now_y + dy[d];
                int next_z = now_z + dz[d];
                if (next_x < 0 || next_y < 0 || next_z < 0 || next_x >= M || next_y >= N || next_z >= H)
                    continue;
                if (visited[next_z][next_y][next_x] || map[next_z][next_y][next_x] != 0)
                    continue;

                queue.offer(new Tuple(next_z, next_y, next_x));
                visited[next_z][next_y][next_x] = true;
                map[next_z][next_y][next_x] = map[now_z][now_y][now_x] + 1;
            }
        }
    }
}

class Tuple {
    int x, y, z;
    Tuple(int z, int y, int x){
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
