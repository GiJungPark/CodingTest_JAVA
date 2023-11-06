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
        int N = Integer.parseInt(st.nextToken()); // 구슬의 개수
        int M = Integer.parseInt(st.nextToken()); // 연관관계의 개수
        int[][] arr = new int[N + 1][N + 1];

        int half = (N / 2) + 1;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int heavy = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            arr[heavy][weight] = 1;
            arr[weight][heavy] = -1;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    if (arr[k][i] != 0 && arr[j][i] == arr[i][k])
                        arr[j][k] = arr[j][i];
                }
            }
        }

        int[] big = new int[N + 1];
        int[] small = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {

                if (arr[i][j] == 1)
                    big[i]++;

                if (arr[i][j] == -1)
                    small[i]++;

            }
        }

        int result = 0;
        //조건이 총구슬의 반이 넘으면 답의 개수를 늘려준다
        for (int i = 1; i <= N; i++) {
            if (big[i] >= half) result++;
            if (small[i] >= half) result++;
        }

        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }

}