
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Main {
    static int N, L;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = parseInt(st.nextToken());
        L = parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = parseInt(st.nextToken());
            }
        }

        int cnt = 0;

        for (int i = 0; i < N; i++) {
            if (goPath(-1, i)) cnt++;
            if (goPath(i, -1)) cnt++;
        }

        System.out.println(cnt);

    }

    public static boolean goPath(int x, int y) {

        int[] path = new int[N];
        boolean[] check = new boolean[N];

        if (x == -1) {
            for (int i = 0; i < N; i++) {
                path[i] = map[i][y];
            }
        }

        if (y == -1) {
            for (int i = 0; i < N; i++) {
                path[i] = map[x][i];
            }
        }

        for (int i = 0; i < N - 1; i++) {
            // 전 높이와 동일한 경우
            if (path[i] == path[i + 1]) continue;

            // 높이 차이가 2 이상인 경우
            if (Math.abs(path[i] - path[i + 1]) > 1) {
                return false;
            }

            // 경사가 내려가는 경우
            if (path[i] > path[i + 1]) {
                for (int j = i + 1; j <= i + L; j++) {
                    // 범위를 벗어나거나, 높이 변동, 경사로를 깐적있는지 체크
                    if (j >= N || path[i + 1] != path[j] || check[j]) {
                        return false;
                    }
                    check[j] = true;
                }
            }

            // 경사가 올라가는 경우
            if (path[i] < path[i + 1]) {
                for (int j = i; j > i - L; j--) {
                    // 범위를 벗어나거나, 높이 변동, 경사로를 깐적있는지 체크
                    if (j < 0 || path[i] != path[j] || check[j]) {
                        return false;
                    }
                    check[j] = true;
                }
            }
        }

        return true;
    }
}
