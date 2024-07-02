import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = parseInt(br.readLine());
        int[] Arr = new int[N];
        int[] length = new int[N];

        for (int i = 0; i < N; i++) {
            Arr[i] = parseInt(br.readLine());
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            length[i] = 1;
            for(int j = 0; j < i; j++) {
                if (Arr[j] < Arr[i]) {
                    length[i] = Math.max(length[i], length[j] + 1);
                }
            }

            max = Math.max(length[i], max);
        }

        System.out.println(N - max);
    }
}