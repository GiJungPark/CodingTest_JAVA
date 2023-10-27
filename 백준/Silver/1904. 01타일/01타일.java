import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 2];

        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= N; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 15746;
        }

        bw.write(dp[N] + "");
        bw.flush();
        bw.close();
        br.close();
    }

}