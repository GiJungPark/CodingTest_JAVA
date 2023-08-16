import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] wine = new int[N];
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }

        if (N > 2) {
            dp[0] = wine[0];
            dp[1] = wine[1] + wine[0];
            dp[2] = Math.max(Math.max(wine[2] + wine[1], wine[2] + wine[0]), dp[1]);

            for (int i = 3; i < N; i++) {
                int data1 = dp[i - 3] + wine[i - 1] + wine[i];
                int data2 = dp[i - 2] + wine[i];
                int data3 = dp[i - 1];
                dp[i] = Math.max(data1, Math.max(data2, data3));
            }
            System.out.println(dp[N - 1]);
        } else if (N == 1) {
            System.out.println(wine[0]);
        } else{
            System.out.println(wine[0] + wine[1]);
        }
    }
}