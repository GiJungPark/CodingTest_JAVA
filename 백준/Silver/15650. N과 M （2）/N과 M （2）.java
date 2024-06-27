import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N;
    private static int M;
    private static int[] Arr;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = parseInt(st.nextToken());
        M = parseInt(st.nextToken());
        Arr= new int[N + 1];

        backTracking(1);

        bw.flush();
        bw.close();
    }

    public static void backTracking(int depth) throws IOException {
        if (depth == M + 1) {
            StringBuilder sb = new StringBuilder();
            for (int num : Arr) {
                if (num != 0) {
                    sb.append(num).append(" ");
                }
            }
            bw.write(sb.append("\n").toString());
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (isAvailable(i, depth)) {
                Arr[depth] = i;
                backTracking(depth + 1);
                Arr[depth] = 0;
            }
        }
    }

    public static boolean isAvailable(int num, int depth) {
        for (int i = 1; i < depth; i++) {
            if (num <= Arr[i]) return false;
        }

        return true;
    }
}
