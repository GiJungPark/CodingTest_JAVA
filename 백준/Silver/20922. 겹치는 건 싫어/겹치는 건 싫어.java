import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = parseInt(st.nextToken());
        int K = parseInt(st.nextToken());
        int[] Arr = new int[N];
        
        if (N == 1 && K == 1) {
            System.out.println(1);
            return;
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            Arr[i] = parseInt(st.nextToken());
        }

        int count = 1;
        int max = 0;
        int startIdx = 0;
        int endIdx = 0;
        int[] temp = new int[100_001];
        temp[Arr[startIdx]]++;

        while (endIdx < N - 1) {
            endIdx++;
            temp[Arr[endIdx]]++;
            count++;


            while (temp[Arr[endIdx]] > K) {
                temp[Arr[startIdx++]]--;
                count--;
            }


            max = Math.max(max, count);

        }

        System.out.println(max);
    }
}

