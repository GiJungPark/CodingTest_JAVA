import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static char[][] map;
    static boolean[][] jihunVisited;
    static boolean[][] fireVisited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Queue<Pair> jihunQueue = new LinkedList<>();
    static Queue<Pair> fireQueue = new LinkedList<>();
    static int R, C;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken()); // R은 미로 행의 개수
        C = Integer.parseInt(st.nextToken()); // C는 열의 개수

        map = new char[R][C];
        jihunVisited = new boolean[R][C];
        fireVisited = new boolean[R][C];
        count = 0;

        for(int i = 0; i < R; i++){
            String step = br.readLine();
            for(int k = 0; k < C; k++){
                map[i][k] = step.charAt(k);
                if(map[i][k] == 'J') {
                    jihunQueue.offer(new Pair(k, i));
                    jihunVisited[i][k] = true;
                    map[i][k] = '.';
                }
                if(map[i][k] == 'F') {
                    fireQueue.offer(new Pair(k, i));
                    fireVisited[i][k] = true;
                }
            }
        }

        if(bfs()){
            bw.write(count + "\n");
        }else{
            bw.write("IMPOSSIBLE \n");
        }


        bw.flush();
        bw.close();
        br.close();
    }

    static boolean bfs(){
        while(!jihunQueue.isEmpty()){
            int jihunSize = jihunQueue.size();
            int fireSize = fireQueue.size();
            for(int j = 0; j < fireSize; j++){
                Pair pair = fireQueue.poll();
                int now_x = pair.x;
                int now_y = pair.y;
                for(int i = 0; i < 4; i++){
                    int next_x = now_x + dx[i];
                    int next_y = now_y + dy[i];
                    if(next_x < 0 || next_y < 0|| next_x >= C || next_y >= R)
                        continue;
                    if(fireVisited[next_y][next_x] || map[next_y][next_x] == '#')
                        continue;
                    fireVisited[next_y][next_x] = true;
                    map[next_y][next_x] = 'F';
                    fireQueue.offer(new Pair(next_x, next_y));
                }
            }

            for(int j = 0; j < jihunSize; j++){
                Pair pair = jihunQueue.poll();
                int now_x = pair.x;
                int now_y = pair.y;
                for(int i = 0; i < 4; i++){
                    int next_x = now_x + dx[i];
                    int next_y = now_y + dy[i];
                    if(next_x < 0 || next_y < 0|| next_x >= C || next_y >= R){
                        count++;
                        return true;
                    }
                    if(jihunVisited[next_y][next_x] || map[next_y][next_x] != '.')
                        continue;
                    jihunVisited[next_y][next_x] = true;
                    jihunQueue.offer(new Pair(next_x, next_y));
                }
            }
            count++;
        }
        return false;
    }
}

class Pair {
    int x, y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
