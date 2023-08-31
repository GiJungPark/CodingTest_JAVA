
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Queue<Pair> queue = new LinkedList<>();
    static int M;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); //M은 상자의 가로 칸의 수
        N = Integer.parseInt(st.nextToken()); //N은 상자의 세로 칸의 수

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int k = 0; k < M; k++){
                map[i][k] = Integer.parseInt(st.nextToken());
                if(map[i][k] == 1) queue.offer(new Pair(k, i));
            }
        }

        bfs();

        boolean flag = false;
        for(int i = 0; i < N; i++){
            for(int k = 0; k < M; k++){
                if(map[i][k] == 0 || flag) {
                    flag = true;
                }
            }
        }

        if(flag){
            bw.write(-1 + "\n");
        } else {
            int max = 0;
            for(int i = 0; i < N; i++){
                for(int k = 0; k < M; k++){
                    if(map[i][k] > max) {
                        max = map[i][k];
                    }
                }
            }
            bw.write((max - 1) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(){
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            int now_x = pair.x;
            int now_y = pair.y;
            visited[now_y][now_x] = true;
            for(int i = 0; i < 4; i++){
                int next_x = now_x + dx[i];
                int next_y = now_y + dy[i];
                if(next_x < 0 || next_y < 0|| next_x >= M || next_y >= N)
                    continue;
                if(visited[next_y][next_x] || map[next_y][next_x] != 0)
                    continue;
                map[next_y][next_x] = map[now_y][now_x] + 1;
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
