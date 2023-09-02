
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] fireVisited;
    static boolean[][] sangVisited;
    static Queue<Pair> fireQueue;
    static Queue<Pair> sangQueue;
    static char[][] map;
    static int W, H;
    static int count;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            map = new char[H][W];
            fireQueue = new LinkedList<>();
            sangQueue = new LinkedList<>();
            fireVisited = new boolean[H][W];
            sangVisited = new boolean[H][W];
            count = 0;

            for(int h = 0; h < H; h++){
                String step = br.readLine();
                for(int w = 0; w < W; w++){
                    map[h][w] = step.charAt(w);
                    if(map[h][w] == '*') {
                        fireQueue.offer(new Pair(w, h));
                        fireVisited[h][w] = true;
                    }
                    if(map[h][w] == '@'){
                        sangQueue.offer(new Pair(w, h));
                        sangVisited[h][w] = true;
                        map[h][w] = '.';
                    }
                }
            }

            if(bfs()){
                bw.write(count + "\n");
            }else{
                bw.write("IMPOSSIBLE" + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static boolean bfs() {
        while(!sangQueue.isEmpty()){
            int fireSize = fireQueue.size();
            int sangSize = sangQueue.size();
            for(int fire = 0; fire < fireSize; fire++){
                Pair poll = fireQueue.poll();
                int now_x = poll.x;
                int now_y = poll.y;
                for(int d = 0; d < 4; d++){
                    int next_x = now_x + dx[d];
                    int next_y = now_y + dy[d];
                    if(next_x < 0 || next_y < 0 || next_x >= W || next_y >= H)
                        continue;
                    if(fireVisited[next_y][next_x] || map[next_y][next_x] != '.')
                        continue;

                    fireQueue.offer(new Pair(next_x, next_y));
                    fireVisited[next_y][next_x] = true;
                    map[next_y][next_x] = '*';
                }
            }

            for(int sang = 0; sang < sangSize; sang++){
                Pair poll = sangQueue.poll();
                int now_x = poll.x;
                int now_y = poll.y;
                for(int d = 0; d < 4; d++){
                    int next_x = now_x + dx[d];
                    int next_y = now_y + dy[d];
                    if(next_x < 0 || next_y < 0 || next_x >= W || next_y >= H){
                        count++;
                        return true;
                    }
                    if(sangVisited[next_y][next_x] || map[next_y][next_x] != '.')
                        continue;

                    sangQueue.offer(new Pair(next_x, next_y));
                    sangVisited[next_y][next_x] = true;
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
