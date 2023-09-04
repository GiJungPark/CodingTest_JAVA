
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static char[][][] map;
    static int[][][] countMap;
    static boolean[][][] visited;
    static int L, R, C;
    static Queue<Tuple> queue;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            if(L + R + C == 0) break;

            count = 0;
            map = new char[L][R][C];
            countMap = new int[L][R][C];
            visited = new boolean[L][R][C];
            queue = new LinkedList<>();

            for(int l = 0; l < L; l++){
                for(int r = 0; r < R; r++){
                    String tmp = br.readLine();
                    for(int c = 0; c < C; c++){
                        map[l][r][c] = tmp.charAt(c);

                        if(map[l][r][c] == 'S') {
                            queue.offer(new Tuple(c, r, l));
                            visited[l][r][c] = true;
                        }
                    }
                }
                br.readLine();
            }

            if(bfs()){
                bw.write("Escaped in " + count + " minute(s).\n");
            }else{
                bw.write("Trapped!\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static boolean bfs() {
        while(!queue.isEmpty()){
            Tuple poll = queue.poll();
            int now_x = poll.x;
            int now_y = poll.y;
            int now_z = poll.z;
            for(int d = 0; d < 6; d++){
                int next_x = now_x + dx[d];
                int next_y = now_y + dy[d];
                int next_z = now_z + dz[d];
                if(next_x < 0 || next_y < 0 || next_z < 0 || next_x >= C || next_y >= R || next_z >= L)
                    continue;
                if(visited[next_z][next_y][next_x] || map[next_z][next_y][next_x] == '#')
                    continue;
                if(map[next_z][next_y][next_x] == 'E') {
                    count = countMap[now_z][now_y][now_x] + 1;
                    return true;
                }

                visited[next_z][next_y][next_x] = true;
                countMap[next_z][next_y][next_x] = countMap[now_z][now_y][now_x] + 1;
                queue.offer(new Tuple(next_x, next_y, next_z));
            }
        }
        return false;
    }
}

class Tuple {
    int x, y, z;
    Tuple(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
