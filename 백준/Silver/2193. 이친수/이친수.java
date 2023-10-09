// 이친수는 0으로 시작하지 않는다.
// 이친수에서는 1이 두 번 연속으로 나타나지 않는다. 즉, 11을 부분 문자열로 갖지 않는다.

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[N + 2];
        dp[1] = 1;
        dp[2] = 1;
        if(N < 3) {
            bw.write(1 + "");
        } else {
           for(int i = 3; i <= N; i++){
               dp[i] = dp[i - 1] + dp[i - 2];
           }
           bw.write(dp[N] + "");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}