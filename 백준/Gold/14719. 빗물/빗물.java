import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = parseInt(st.nextToken());
        int W = parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] Arr = new int[W];

        for (int i = 0; i < W; i++) {
            Arr[i] = parseInt(st.nextToken());
        }

        int start = Arr[0];
        int total = 0;

        for (int i = 1; i < W - 1; i++) {

            if (start < Arr[i]) {
                start = Arr[i];
                continue;
            }

            int end = Arr[i];
            for (int j = i + 1; j < W; j++) {
                if (end < Arr[j]) {
                    end = Arr[j];
                }
            }

            total += Math.min(start, end) - Arr[i];
        }

        System.out.println(total);
    }
}
