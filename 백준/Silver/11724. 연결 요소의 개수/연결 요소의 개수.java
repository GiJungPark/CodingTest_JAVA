import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Main {
    private static ArrayList<Integer>[] list;
    private static boolean[] visited;
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int node = parseInt(st.nextToken());
        int edge = parseInt(st.nextToken());

        list = new ArrayList[node + 1];
        visited = new boolean[node + 1];
        for (int i = 1; i <= node; i++) {
            list[i] = new ArrayList<>();
            visited[i] = false;
        }

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int s = parseInt(st.nextToken());
            int e = parseInt(st.nextToken());
            list[s].add(e);
            list[e].add(s);
        }

        for (int i = 1; i <= node; i++) {
            if (!visited[i]) {
                DFS(i);
                count++;
            }
        }

        System.out.println(count);
    }

    public static void DFS(int s) {
        if (visited[s]) {
            return;
        }

        visited[s] = true;

        for (int value : list[s]) {
            if (!visited[value]) {
                DFS(value);
            }
        }
    }
}