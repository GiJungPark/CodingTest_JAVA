import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j <= i; j++){
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = N - 2; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                dp[i][j] += Math.max(dp[i+1][j], dp[i+1][j+1]);
            }
        }

        bw.write(dp[0][0] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}