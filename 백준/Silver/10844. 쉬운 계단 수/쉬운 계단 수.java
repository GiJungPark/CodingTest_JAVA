import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    private static final int NUMBER_RANGE_MIN = 0;
    private static final int START_NUMBER_RANGE_MIN = 1;
    private static final int NUMBER_RANGE_MAX = 9;
    private static final int DP_MAX_NUMBER = 101;
    private static final int MOD_NUMBER = 1000000000;

    private static int N;
    private static long[][] dp;

    public static void main(String[] args) throws Exception {

        // 값(N, 계단수) 입력받기
        inputValue();

        // dp[계단수][자리수] 생성 및 초기 설정
        initDp();

        // dp 연산: 전 계단에서 인접한 1 ~ 9숫자의 총합 더하기
        setDp();

        // N 계단 자리수의 총합 구하기
        long result = getResult();

        // 결과 출력
        outputValue(result);
    }

    private static void inputValue() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        br.close();
    }

    private static void outputValue(long result) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(result % MOD_NUMBER + "");
        bw.flush();

        bw.close();
    }

    private static void initDp() {
        dp = new long[DP_MAX_NUMBER][NUMBER_RANGE_MAX + 2];

        for(int i = START_NUMBER_RANGE_MIN; i <= NUMBER_RANGE_MAX; i++) {
            dp[1][i] = 1;
        }
    }

    // 점화식에서 1~8은 0~9까지의 양 옆의 숫자를 더하면 된다.
    // 0은 1의 값만 받을수 있으므로 따로 처리하고,
    // 9는 배열을 늘려서 빈 배열 값을 더하는 것으로 해결한다.
    private static void setDp() {
        for(int i = 2; i <= N; i++) {

            dp[i][NUMBER_RANGE_MIN] = dp[i - 1][1];

            for(int j = START_NUMBER_RANGE_MIN; j <= NUMBER_RANGE_MAX; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD_NUMBER;
            }
        }
    }

    private static long getResult() {
        long result = 0;

        for(int i = NUMBER_RANGE_MIN; i <= NUMBER_RANGE_MAX; i++) {
            result += dp[N][i];
        }

        return result;
    }
}