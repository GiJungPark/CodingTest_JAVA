import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        int max = 0;
        for(int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(br.readLine());
            max = Math.max(tmp, max);
            list.add(tmp);
        }

        long[] dp = new long[1000001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i = 4; i <= max; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1000000009;
        }

        for(int num : list)
            bw.write(dp[num] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

}