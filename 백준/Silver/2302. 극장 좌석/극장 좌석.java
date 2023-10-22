import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 2];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= N; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        int result = 1;
        int before_seat = 0;
        for(int i = 0; i < M; i++) {
            int temp = Integer.parseInt(br.readLine());
            result *= dp[temp - before_seat - 1];
            before_seat = temp;
        }

        result *= dp[N - before_seat];

        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }

}