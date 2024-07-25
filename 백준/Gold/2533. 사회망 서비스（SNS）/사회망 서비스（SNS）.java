import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Main {
    static int N;
    static List<Integer>[] arr;
    static boolean[] visited;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = parseInt(br.readLine());

        // DP 배열 생성
        // 0은 얼리 어답터가 아닌 경우, 1은 얼리 어답터인 경우
        dp = new int[N + 1][2];

        // 방문 배열 생성
        visited = new boolean[N + 1];

        // 인접 리스트 생성
        arr = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        // 인접 리스트 초기화
        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = parseInt(st.nextToken());
            int end = parseInt(st.nextToken());
            arr[start].add(end);
            arr[end].add(start);
        }

        DFS(1);

        int result = Math.min(dp[1][0], dp[1][1]);

        System.out.println(result);
    }

    static void DFS(int number) {
        visited[number] = true;
        dp[number][0] = 0;
        dp[number][1] = 1;

        // 부모 노드가 얼리 어답터가 아니면, 자식은 무조건 얼리 어답터여야 한다.
        // 부모 노드가 얼리 어답터면, 자식은 얼리 어답터일 수도 있고 아닐 수도 있다.
        for (Integer child : arr[number]) {
            if (!visited[child]) {
                DFS(child);
                dp[number][0] += dp[child][1];
                dp[number][1] += Math.min(dp[child][0], dp[child][1]);
            }
        }
    }
}