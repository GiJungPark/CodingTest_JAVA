import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N + 1][2];
            int[][] dp = new int[100001][2];
            for(int j = 0; j < 2; j++) {
                st = new StringTokenizer(br.readLine());
                for (int i = 1; i <= N; i++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dp[1][0] = arr[1][0];
            dp[1][1] = arr[1][1];

            int result = Math.max(dp[1][0], dp[1][1]);
            for(int i = 2; i <= N; i++) {
                dp[i][0] = Math.max(dp[i - 1][1], Math.max(dp[i - 2][0], dp[i - 2][1])) + arr[i][0];
                dp[i][1] = Math.max(dp[i - 1][0], Math.max(dp[i - 2][0], dp[i - 2][1])) + arr[i][1];
                result = Math.max(result, Math.max(dp[i][0], dp[i][1]));
            }

            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}