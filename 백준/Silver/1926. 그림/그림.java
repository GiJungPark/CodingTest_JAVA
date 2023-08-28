import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int N;
    static int M;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 세로 사이즈
        M = Integer.parseInt(st.nextToken()); // 가로 사이즈

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int k = 0; k < M; k++){
                map[i][k] = Integer.parseInt(st.nextToken());
                if(map[i][k] == 0) visited[i][k] = true;
            }
        }



        int max = 0;
        int count = 0;
        for(int i = 0; i < N; i++){
            for(int k = 0; k < M; k++){
                if(!visited[i][k]){
                    int step = dfs(i, k);
                    max = max > step ? max : step;
                    count++;
                }
            }
        }

        bw.write(count + "\n");
        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int dfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        int count = 1;
        queue.offer(new int[] {x, y});
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int now_x = now[0];
            int now_y = now[1];
            visited[now_x][now_y] = true;
            int tmp = map[now_x][now_y];
            for(int i = 0; i < 4; i++){
                int next_x = now_x + dx[i];
                int next_y = now_y + dy[i];
                if(next_x < 0 || next_y < 0|| next_x >= N || next_y >= M)
                    continue;
                if(visited[next_x][next_y] || tmp != 1)
                    continue;
                queue.offer(new int[] {next_x,next_y});
                visited[next_x][next_y] = true;
                count++;
            }
        }
        return count;
    }
}