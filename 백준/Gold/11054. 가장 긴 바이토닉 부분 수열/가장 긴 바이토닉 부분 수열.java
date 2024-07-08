import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Main {

    static int[] r_dp, l_dp, arr;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = parseInt(st.nextToken());
        }

        r_dp = new int[N];
        l_dp = new int[N];
        for (int i = 0; i < N; i++) {
            LIS(i);
            LDS(i);
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, r_dp[i] + l_dp[i]);
        }

        System.out.println(max - 1);
    }

    static int LIS(int num) {
        if (r_dp[num] == 0) {

            r_dp[num] = 1;

            for (int i = num - 1; i >= 0; i--) {
                if (arr[num] > arr[i]) {
                    r_dp[num] = Math.max(r_dp[num], LIS(i) + 1);
                }
            }
        }

        return r_dp[num];
    }

    static int LDS(int num) {
        if (l_dp[num] == 0) {

            l_dp[num] = 1;

            for (int i = num + 1; i < l_dp.length; i++) {
                if (arr[num] > arr[i]) {
                    l_dp[num] = Math.max(l_dp[num], LDS(i) + 1);
                }
            }
        }
        return l_dp[num];
    }
}