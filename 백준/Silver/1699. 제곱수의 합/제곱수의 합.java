import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                int temp = dp[i - (j * j)] + 1;
                if (dp[i] > temp) {
                    dp[i] = temp;
                }
            }
        }

        bw.write(dp[N] + "");
        bw.flush();
        bw.close();
        br.close();
    }

}