import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Main {

    static int n, m;
    static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int C = parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < C; i++) {
            st = new StringTokenizer(br.readLine());
            n = parseInt(st.nextToken());
            m = parseInt(st.nextToken());

            int[] movieIndex = new int[n + 1];
            tree = new int[n + m + 1];

            for (int j = 1; j <= n; j++) {
                movieIndex[j] = m + j;
                update(movieIndex[j], 1);
            }

            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                int target = parseInt(st.nextToken());
                int targetIndex = movieIndex[target];
                sb.append(sum(targetIndex - 1)).append(" ");

                update(targetIndex, -1);
                movieIndex[target] = m - j + 1;
                update(movieIndex[target], 1);
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void update(int index, int value) {
        while (index <= n + m) {
            tree[index] += value;
            index += (index & -index);
        }
    }

    static int sum(int index) {
        int result = 0;

        while (index > 0) {
            result += tree[index];
            index -= (index & -index);
        }

        return result;
    }
}