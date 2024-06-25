import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = parseInt(st.nextToken());
        int K = parseInt(st.nextToken());

        int[][] dp = new int[N + 1][K + 1];
        int[] W = new int[N + 1];
        int[] V = new int[N + 1];


        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = parseInt(st.nextToken());
            V[i] = parseInt(st.nextToken());

        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if (W[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                }

                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - W[i]] + V[i]);
                }
            }
        }

        System.out.println(dp[N][K]);

    }
}
