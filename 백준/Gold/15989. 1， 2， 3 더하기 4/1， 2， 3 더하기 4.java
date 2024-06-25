import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = parseInt(br.readLine());
        int[][] Arr = new int[10001][4];
        Arr[1][1] = Arr[2][1] = Arr[2][2] = Arr[3][1] = Arr[3][2] = Arr[3][3] = 1;

        for (int i = 4; i <= 10000; i++) {
            Arr[i][1] = Arr[i - 1][1];
            Arr[i][2] = Arr[i - 2][1] + Arr[i - 2][2];
            Arr[i][3] = Arr[i - 3][1] + Arr[i - 3][2] + Arr[i - 3][3];
        }

        for (int i = 0; i < N; i++) {
            int T = parseInt(br.readLine());
            System.out.println(Arr[T][1] + Arr[T][2] + Arr[T][3]);
        }

    }
}