import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Main {
    static int N;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] arr;
    static int[] operator;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = parseInt(st.nextToken());
        }

        // 0: 덧셈, 1: 뺄셈, 2: 곱셈, 3: 나눗셈
        operator = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = parseInt(st.nextToken());
        }

        DFS(1, arr[0]);

        System.out.println(max);
        System.out.println(min);
    }

    public static void DFS(int depth, int num) {
        if (depth == N) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {

                operator[i]--;

                switch (i) {
                    case 0:
                        DFS(depth + 1, num + arr[depth]);
                        break;
                    case 1:
                        DFS(depth + 1, num - arr[depth]);
                        break;
                    case 2:
                        DFS(depth + 1, num * arr[depth]);
                        break;
                    case 3:
                        DFS(depth + 1, num / arr[depth]);
                        break;
                }

                operator[i]++;
            }
        }
    }
}