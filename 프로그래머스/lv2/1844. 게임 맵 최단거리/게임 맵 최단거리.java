import java.util.Queue;
import java.util.LinkedList;

class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    boolean[][] visited;
    int[][] map;
    int N; //가로 길이
    int M; //세로 길이
    
    public int solution(int[][] maps) {
        int answer = 0;
        N = maps[0].length;
        M = maps.length;
        visited = new boolean[M][N];
        map = new int[M][N];
        for(int i = 0; i < M; i++){
            for(int k = 0; k < N; k++){
                map[i][k] = maps[i][k];
            }
        }
        visited[0][0] = true;
        bfs(new Pair(0, 0));
        
        if(map[M-1][N-1] != 1) return map[M-1][N-1];
        return -1;
    }
    
    public void bfs(Pair pair){
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(pair);
        
        while(!queue.isEmpty()){
            Pair now = queue.poll();
            for(int i = 0; i < 4; i++){
                int next_x = now.x + dx[i];
                int next_y = now.y + dy[i];
                if(next_x < 0 || next_y < 0 || next_x >= N || next_y >= M)
                    continue;
                if(visited[next_y][next_x] || map[next_y][next_x] == 0)
                    continue;
                
                queue.offer(new Pair(next_x, next_y));
                map[next_y][next_x] = map[now.y][now.x] + 1;
                visited[next_y][next_x] = true;
            }
        }
    }
}

class Pair{
    int x, y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}