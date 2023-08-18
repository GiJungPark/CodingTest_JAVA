import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static char[][] map;
    static boolean[][] visited;
    static int N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new boolean[N][N];

        // 1. 일반인 map 배열에 값 입력하기
        for(int i = 0 ; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String step = st.nextToken();
            for(int k = 0; k < N; k++){
                map[i][k] = step.charAt(k);
            }
        }

        // 2. 일반인 시점 구역의 개수 구하기
        int normalCount = 0;
        for(int i = 0; i < N; i++){
            for(int k = 0; k < N; k++){
                if(!visited[i][k]) {
                    dfs(i, k);
                    normalCount++;
                }
            }
        }

        // 3. 일반인 -> 적록색약 map으로 수정, 배열 'G'를 'R'로 통합
        for(int i = 0 ; i < N; i++){
            for(int k = 0; k < N; k++){
                if(map[i][k] == 'G') map[i][k] = 'R';
            }
        }

        // 재탐색을 위해 visited 배열 초기화
        visited = new boolean[N][N];

        // 4. 적록색약 시점 구역의 개수 구하기
        int specialCount = 0;
        for(int i = 0; i < N; i++){
            for(int k = 0; k < N; k++){
                if(!visited[i][k]) {
                    dfs(i, k);
                    specialCount++;
                }
            }
        }

        System.out.println(normalCount + " " + specialCount);
    }
    
    //dfs를 활용한 같은 영역 탐색
    private static void dfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int now_x = now[0];
            int now_y = now[1];
            visited[now_x][now_y] = true;
            char tmp = map[now_x][now_y];
            for(int i = 0; i < 4; i++){
                int next_x = now_x + dx[i];
                int next_y = now_y + dy[i];
                if(next_x < 0 || next_y < 0|| next_x >= N || next_y >= N)
                    continue;
                if(visited[next_x][next_y] || tmp != map[next_x][next_y])
                    continue;
                queue.offer(new int[] {next_x,next_y});
                visited[next_x][next_y] = true;
            }
        }
    }
}