import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coin = new int[N];
        int[] dp = new int[K + 1];

        for(int i = 0; i < N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 1;

        // K = 10, N = 1, 2, 5
        for(int i = 0; i < N; i++) {
            for(int j = 1; j <= K; j++) {
                if(j >= coin[i]) {
                    dp[j] += dp[j - coin[i]];
                }
            }
        }

        bw.write(dp[K] + "");
        bw.flush();
        bw.close();
        br.close();
    }

}