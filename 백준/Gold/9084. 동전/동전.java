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

        int T = Integer.parseInt(br.readLine()); // 테스트케이스 개수
        for(int t = 0; t < T; t++){
            int N = Integer.parseInt(br.readLine()); // 동전 가지의 수
            int[] coinList = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int n = 0; n < N; n++)
                coinList[n] = Integer.parseInt(st.nextToken());
            int targetValue = Integer.parseInt(br.readLine());
            int[] dp = new int[targetValue + 1];
            dp[0] = 1;

            for(int coin : coinList){
                for(int i = coin; i <= targetValue; i++){
                    dp[i] += dp[i - coin];
                }
            }

            bw.write(dp[targetValue] +"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}