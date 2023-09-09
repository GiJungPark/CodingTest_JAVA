
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {
    static Integer[][] dp = new Integer[41][2];
    static int zero;
    static int one;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        for(int t = 0; t < T; t++){
            int N = Integer.parseInt(br.readLine());
            Integer[] result = fib(N);
            bw.write(result[0] + " " + result[1] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static Integer[] fib(int value) {
        if(dp[value][0] == null || dp[value][1] == null) {
            dp[value][0] = fib(value - 1)[0] + fib(value - 2)[0];
            dp[value][1] = fib(value - 1)[1] + fib(value - 2)[1];
        }
        return dp[value];
    }
}
