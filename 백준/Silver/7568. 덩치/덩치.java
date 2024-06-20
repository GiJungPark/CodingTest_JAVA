import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = parseInt(br.readLine());
        Deongchi[] Arr = new Deongchi[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Arr[i] = new Deongchi(parseInt(st.nextToken()), parseInt(st.nextToken()));
        }

        for (int i = 0; i < N; i++) {
            int rank = 1;
            for (int j = 0; j < N; j++) {
                if (Arr[i].weight < Arr[j].weight && Arr[i].height < Arr[j].height) {
                    rank++;
                }
            }
            Arr[i].rank = rank;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(Arr[i].rank + " ");
        }

        System.out.println(sb);
    }
    static class Deongchi {
        int weight;
        int height;
        int rank;

        Deongchi(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }

    }

}