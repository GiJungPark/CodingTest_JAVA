import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final int MOD = 1000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        int size = N.length();
        int[] dp = new int[size + 1];
        dp[0] = 1;
        for (int i = 1; i <= size; i++) {
            int now = N.charAt(i-1) - '0';
            if(1 <= now && now <= 9){
                dp[i] += dp[i-1] % MOD;
            }
            if(i == 1) continue;

            int before = N.charAt(i-2) - '0';
            if(before != 0){
                int step = before * 10 + now;
                if(10 <= step && step <= 26){
                    dp[i] += dp[i-2] % MOD;
                }
            }
        }
        System.out.println(dp[size] % MOD);
    }
}