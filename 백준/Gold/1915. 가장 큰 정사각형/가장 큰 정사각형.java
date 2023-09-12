import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N + 1][M + 1];
        for(int n = 1; n <= N; n++){
            String tmp = br.readLine();
            for(int m = 1; m <= M; m++){
                map[n][m] = tmp.charAt(m - 1) - '0';
            }
        }

        int ans = 0;
        for(int n = 1; n <= N; n++){
            for(int m = 1; m <= M; m++){
                if(map[n][m] == 1 && ans == 0) ans++;
                if(map[n][m] == 0) continue;
                if(map[n-1][m] == 0 || map[n][m-1] == 0 || map[n-1][m-1] == 0) continue;
                map[n][m] = Math.min(map[n-1][m-1], Math.min(map[n-1][m], map[n][m-1])) + 1;
                ans = Math.max(ans, map[n][m]);
            }
        }

        bw.write(ans * ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}