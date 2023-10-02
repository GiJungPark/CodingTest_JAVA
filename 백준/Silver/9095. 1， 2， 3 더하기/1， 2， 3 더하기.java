import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            int num = Integer.parseInt(br.readLine());
            int[] dp = new int[11];

            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;

            for(int i = 4; i <= num; i++){
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }
            bw.write(dp[num] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}