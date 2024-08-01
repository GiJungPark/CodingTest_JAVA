import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] DP = new int[1000][1000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        palindrome(str);
    }

    static void palindrome(String str) {

        for (int i = 0; i < str.length(); i++) {
            DP[i][i] = 1;
        }

        for (int i = 0; i < str.length() - 1; i++) {
            DP[i][i + 1] = 2;
            if (str.charAt(i) == str.charAt(i + 1)) {
                DP[i][i + 1]++;
            }
        }

        for (int i = 2; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                int start = j - i;

                if (str.charAt(start) == str.charAt(j)) {
                    DP[start][j] = (DP[start + 1][j] + DP[start][j - 1] + 1) % 10007;
                    continue;
                }
                DP[start][j] = (10007 + DP[start + 1][j] + DP[start][j - 1] - DP[start + 1][j - 1]) % 10007;
            }
        }

        System.out.println(DP[0][str.length() - 1]);
    }
}