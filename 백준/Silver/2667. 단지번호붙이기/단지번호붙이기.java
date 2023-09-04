import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static int[][] map;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for(int j = 0; j < N; j++){
            String tmp = br.readLine();
            for(int k = 0; k < N; k++){
                map[j][k] = tmp.charAt(k) - '0';
            }
        }

        List<Integer> list = new ArrayList<>();
        for(int m = 0; m < N; m++){
            for(int n = 0; n < N; n++){
                if(map[m][n] != 0 && !visited[m][n]) {
                    visited[m][n] = true;
                    list.add(bfs(new Pair(n, m)));
                }
            }
        }

        Collections.sort(list);

        bw.write(list.size() + "\n");
        for(int i = 0; i < list.size(); i++)
            bw.write(list.get(i) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static int bfs(Pair pair) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(pair);
        int count = 1;
        while(!queue.isEmpty()){
            Pair poll = queue.poll();
            int now_x = poll.x;
            int now_y = poll.y;
            for(int d = 0; d < 4; d++){
                int next_x = now_x + dx[d];
                int next_y = now_y + dy[d];
                if(next_x < 0 || next_y < 0 || next_x >= N || next_y >= N)
                    continue;
                if(visited[next_y][next_x] || map[next_y][next_x] != 1)
                    continue;
                queue.offer(new Pair(next_x, next_y));
                visited[next_y][next_x] = true;
                count++;
            }
        }
        return count;
    }
}

class Pair {
    int x, y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
