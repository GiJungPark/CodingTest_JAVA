import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 유니온 파인드
public class Main {
    static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 도시의 수
        int M = Integer.parseInt(br.readLine()); // 여행 게획에 속한 도시의 수

        int[][] map = new int[N + 1][N + 1];
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] route = new int[M + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= M; i++){
            route[i] = Integer.parseInt(st.nextToken());
        }

        // 처음 각 노드의 대표는 자기 자신이다.
        parent = new int[N + 1];
        for(int i = 1; i <= N; i++){
            parent[i] = i;
        }

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(map[i][j] == 1) union(i, j);
            }
        }

        // 여행 계획 도시들이 1개의 대표 도시로 연결돼 있는지 확인하기
        int index = find(route[1]);
        for(int i = 2; i < route.length; i++){
            if(index != find(route[i])) {
                bw.write("NO \n");
                bw.flush();
                bw.close();
                br.close();
                return;
            }
        }
        bw.write("YES \n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void union(int a, int b) { // union 연산: 대표 노드끼리 연결하기
        a = find(a);
        b = find(b);
        if(a != b) {
            parent[b] = a;
        }
    }

    public static int find(int a) { // find 연산
        if(a == parent[a]) {
            return a;
        } else {
            return parent[a] = find(parent[a]); // 재귀 함수의 형태로 find 연산 구현
        }
    }
}