
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static int[][] distance;
    static final int MAX = 10000001;

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        distance = new int[N + 1][N + 1];
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(i==j)
                    distance[i][j] = 0;
                else
                    distance[i][j] = MAX;
            }
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            distance[start][end] = 1;
            distance[end][start] = 1;
        }

        for(int k = 1; k <= N; k++){
            for(int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if(distance[i][j] > distance[i][k] + distance[k][j])
                        distance[i][j] = distance[i][k] + distance[k][j];
                }
            }
        }

        int Min = Integer.MAX_VALUE;
        int answer = -1;

        for(int i = 1; i <= N; i++){
            int tmp = 0;
            for(int j = 1; j <= N; j++){
                tmp = tmp + distance[i][j];
            }
            if(Min > tmp){
                Min = tmp;
                answer = i;
            }
        }
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
