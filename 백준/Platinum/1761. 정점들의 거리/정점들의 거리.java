import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Main {

    static int N, H;
    static List<Node>[] graph;
    static int[][] dp;
    static int[] depth;
    static int[] dis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = parseInt(br.readLine());
        graph = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = parseInt(st.nextToken());
            int end = parseInt(st.nextToken());
            int value = parseInt(st.nextToken());

            graph[start].add(new Node(end, value));
            graph[end].add(new Node(start, value));
        }

        H = getTreeHeight();
        depth = new int[N + 1];
        dis = new int[N + 1];
        dp = new int[N + 1][H];

        init(1, 1, 0);
        fillParents();

        StringBuilder sb = new StringBuilder();
        int M = parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = parseInt(st.nextToken());
            int b = parseInt(st.nextToken());

            int result = LCA(a, b);
            sb.append(dis[a] + dis[b] - 2 * dis[result]).append("\n");
        }

        System.out.println(sb);
    }

    static int getTreeHeight() {
        return (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;
    }

    static void init(int current, int height, int before) {
        depth[current] = height;
        for (Node node : graph[current]) {
            if (node.next != before) {
                dis[node.next] = dis[current] + node.value;
                init(node.next, height + 1, current);
                dp[node.next][0] = current;
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

    static class Node {
        int next, value;

        Node(int next, int value) {
            this.next = next;
            this.value = value;
        }
    }
}
