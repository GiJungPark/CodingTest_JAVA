import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static StringBuffer sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();

        System.out.println(dfs(S, T));

    }

    public static int dfs(String S, String T) {

        if (T.length() == S.length()) {
            if(T.equals(S)) {
                return 1;
            }

            return 0;
        }

        int ans = 0;
        if (T.charAt(T.length() - 1) == 'A') {
            ans += dfs(S, T.substring(0, T.length() - 1));
        }

        if (T.charAt(0) == 'B') {
            sb = new StringBuffer(T.substring(1));
            ans += dfs(S, sb.reverse().toString());
        }

        return ans > 0 ? 1 : 0;
    }
}
