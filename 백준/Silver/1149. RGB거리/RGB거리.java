import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    final static int RED = 0;
    final static int GREEN = 1;
    final static int BLUE = 2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][3];
        int[][] dp = new int[N][3];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][RED] = Integer.parseInt(st.nextToken());
            arr[i][GREEN] = Integer.parseInt(st.nextToken());
            arr[i][BLUE] = Integer.parseInt(st.nextToken());
        }

        dp[0][RED] = arr[0][RED];
        dp[0][GREEN] = arr[0][GREEN];
        dp[0][BLUE] = arr[0][BLUE];

        for(int i = 1; i < N; i++){
            dp[i][RED] = Math.min(dp[i - 1][GREEN], dp[i - 1][BLUE]) + arr[i][RED];
            dp[i][GREEN] = Math.min(dp[i - 1][RED], dp[i - 1][BLUE]) + arr[i][GREEN];
            dp[i][BLUE] = Math.min(dp[i - 1][RED], dp[i - 1][GREEN]) + arr[i][BLUE];
        }

        int result = Math.min(Math.min(dp[N - 1][RED], dp[N - 1][GREEN]), dp[N - 1][BLUE]);

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}