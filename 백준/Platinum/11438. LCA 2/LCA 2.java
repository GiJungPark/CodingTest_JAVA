
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Main {

    static int N, H;
    static List<Integer>[] graph;
    static int[] depth;
    static int[][] dp;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = parseInt(br.readLine());
        H = (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;
        graph = new List[N + 1];
        depth = new int[N + 1];
        dp = new int[N + 1][H];

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = parseInt(st.nextToken());
            int end = parseInt(st.nextToken());

            graph[start].add(end);
            graph[end].add(start);
        }

        init(1, 1, 0);
        fillParents();

        StringBuilder sb = new StringBuilder();
        int M = parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = parseInt(st.nextToken());
            int b = parseInt(st.nextToken());

            sb.append(LCA(a, b)).append("\n");
        }

        System.out.println(sb);
    }

    static void init(int current, int height, int before) {
        depth[current] = height;

        for (int next : graph[current]) {
            if (next != before) {
                init(next, height + 1, current);
                dp[next][0] = current;
            }
        }
    }

    static void fillParents() {
        for (int i = 1; i < H; i++) {
            for (int j = 1; j <= N; j++) {
                dp[j][i] = dp[dp[j][i - 1]][i - 1];
            }
        }
    }

    static int LCA(int a, int b) {
        int ah = depth[a];
        int bh = depth[b];

        if (ah < bh) {
            int temp = a;
            a = b;
            b = temp;
        }

        for (int i = H - 1; i >= 0; i--) {
            if (Math.pow(2, i) <= depth[a] - depth[b]) {
                a = dp[a][i];
            }
        }

        if (a == b) {
            return a;
        }

        for (int i = H - 1; i >= 0; i--) {
            if (dp[a][i] != dp[b][i]) {
                a = dp[a][i];
                b = dp[b][i];
            }
        }

        return dp[a][0];
    }
}
