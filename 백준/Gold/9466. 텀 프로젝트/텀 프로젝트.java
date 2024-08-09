import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Main {

    static int[] arr;
    static boolean[] visited, done;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int TC = parseInt(br.readLine());

        for (int tc = 0; tc < TC; tc++) {
            int N = parseInt(br.readLine());
            arr = new int[N + 1];
            visited = new boolean[N + 1];
            done = new boolean[N + 1];
            count = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                arr[i] = parseInt(st.nextToken());
            }

            for (int i = 1; i <= N; i++) {
                if (!done[i]) {
                    DFS(i);
                }
            }

            sb.append(N - count).append("\n");
        }

        System.out.println(sb);
    }

    private static void DFS(int index) {
        if (visited[index]) {
            done[index] = true;
            count++;
        } else {
            visited[index] = true;
        }

        if (!done[arr[index]]) {
            DFS(arr[index]);
        }

        visited[index] = false;
        done[index] = true;
    }

}
