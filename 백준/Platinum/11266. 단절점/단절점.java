
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Main {

    static int order = 1;
    static int[] discovery;
    static boolean[] isCutVertex;
    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = parseInt(st.nextToken());
        int E = parseInt(st.nextToken());

        list = new List[V + 1];
        for (int i = 0; i <= V; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = parseInt(st.nextToken());
            int e = parseInt(st.nextToken());

            list[s].add(e);
            list[e].add(s);
        }

        discovery = new int[V + 1];
        isCutVertex = new boolean[V + 1];

        for (int i = 1; i <= V; i++) {
            if (discovery[i] == 0) {
                DFS(i, true);
            }
        }

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i = 1; i <= V; i++) {
            if (isCutVertex[i]) {
                cnt++;
                sb.append(i).append(" ");
            }
        }
        sb.insert(0, "\n").insert(0, cnt);

        System.out.println(sb);
    }

    static int DFS(int vertex, boolean isRoot) {
        discovery[vertex] = order++;
        int ret = discovery[vertex];
        int child = 0;

        for (int now : list[vertex]) {
            if (discovery[now] == 0) {
                child++;

                int low = DFS(now, false);

                if (!isRoot && low >= discovery[vertex]) {
                    isCutVertex[vertex] = true;
                }

                ret = Math.min(ret, low);
            } else {
                ret = Math.min(ret, discovery[now]);
            }
        }

        if (isRoot && child >= 2) {
            isCutVertex[vertex] = true;
        }

        return ret;
    }
}