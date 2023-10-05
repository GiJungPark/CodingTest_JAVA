import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        dp[0] = dp[1] = 0;
        for(int i = 2; i <= N; i++){
            dp[i] = dp[i - 1] + 1;
            if(i % 2 == 0){
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            if(i % 3 == 0){
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }

        bw.write(dp[N] + "\n");

        bw.write(N + " ");
        while(N > 1){
            int min = dp[N - 1];
            int temp = N - 1;
            if(N % 3 == 0 && dp[N / 3] < min){
                min = dp[N / 3];
                temp = N / 3;
            }
            if(N % 2 == 0 && dp[N / 2] < min){
                min = dp[N / 2];
                temp = N / 2;
            }
            N = temp;
            bw.write(N + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
