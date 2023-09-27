import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[] parent;
    static int[][] map;
    static int N, M, sNum;
    static boolean[][] visited;
    static ArrayList<ArrayList<int[]>> sumList;
    static ArrayList<int[]> mList;
    static PriorityQueue<bEdge> pq;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sNum = 1;
        sumList = new ArrayList<>();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] != 0 && visited[i][j] != true) {
                    BFS(i, j);
                    sNum++;
                    sumList.add(mList);
                }
            }
        }

        pq = new PriorityQueue<>();
        for(int i = 0; i < sumList.size(); i++){
            ArrayList<int[]> now = sumList.get(i);
            for(int j = 0; j < now.size(); j++){
                int r = now.get(j)[0];
                int c = now.get(j)[1];
                int now_s = map[r][c];
                for(int d = 0; d < 4; d++){
                    int tempR = dr[d];
                    int tempC = dc[d];
                    int blenght = 0;
                    while (r + tempR >= 0 && r + tempR < N && c + tempC >= 0 && c + tempC < M){
                        if(map[r + tempR][c + tempC] == now_s)
                            break;
                        else if(map[r + tempR][c + tempC] != 0) {
                            if(blenght > 1)
                                pq.add(new bEdge(now_s, map[r + tempR][c + tempC], blenght));
                            break;
                        } else blenght++;

                        if(tempR < 0) tempR--;
                        else if(tempR > 0) tempR++;
                        else if(tempC < 0) tempC--;
                        else if(tempC > 0) tempC++;
                    }
                }
            }
        }

        parent = new int[sNum];
        for(int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        int useEdge = 0;
        int result = 0;
        while(!pq.isEmpty()) {
            bEdge now = pq.poll();
            if(find(now.start) != find(now.end)){
                union(now.start, now.end);
                result = result + now.value;
                useEdge++;
            }
        }

        if(useEdge == sNum - 2) {
            bw.write(result + "\n");
        } else {
            bw.write(-1 + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }

    public static int find(int a) {
        if(a == parent[a])
            return a;
        else
            return parent[a] = find(parent[a]);
    }

    public static void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        mList = new ArrayList<>();
        int[] start = {i, j};
        queue.add(start);
        mList.add(start);
        visited[i][j] = true;
        map[i][j] = sNum;
        while(!queue.isEmpty()) {
            int now[] = queue.poll();
            int r = now[0];
            int c = now[1];
            for(int d = 0; d < 4; d++) {
                int tempR = dr[d];
                int tempC = dc[d];
                while (r + tempR >= 0 && r + tempR < N && c + tempC >= 0 && c + tempC < M){
                    if(!visited[r + tempR][c + tempC] && map[r + tempR][c + tempC] != 0) {
                        addNode(r + tempR, c + tempC, queue);
                    } else break;
                    if(tempR < 0) tempR--;
                    else if(tempR > 0) tempR++;
                    else if(tempC < 0) tempC--;
                    else if(tempC > 0) tempC++;
                }
            }
        }
    }

    private static void addNode(int i, int j, Queue<int[]> queue) {
        map[i][j] = sNum;
        visited[i][j] = true;
        int[] tmp = {i, j};
        mList.add(tmp);
        queue.add(tmp);
    }
}

class bEdge implements Comparable<bEdge>{
    int start;
    int end;
    int value;
    bEdge(int start, int end, int value){
        this.start = start;
        this.end = end;
        this.value = value;
    }

    @Override
    public int compareTo(bEdge o) {
        return this.value - o.value;
    }
}
