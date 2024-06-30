import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = parseInt(br.readLine());

        int[] Arr = new int[1_001];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int idx = parseInt(st.nextToken());
            int value = parseInt(st.nextToken());

            Arr[idx] = value;
        }

        int result = 0;

        int left = 0;
        for (int i = 1; i < 1_001; i++) {

            if (left < Arr[i]) left = Arr[i];
            int right = 0;
            for (int j = i + 1; j < 1_001; j++) {
                if (right < Arr[j]) right = Arr[j];
            }

            int mark = Math.min(right, left);

            if (mark >= Arr[i]) {
                result += mark;
            } else {
                result += Arr[i];
            }

        }

        System.out.println(result);
    }
}
