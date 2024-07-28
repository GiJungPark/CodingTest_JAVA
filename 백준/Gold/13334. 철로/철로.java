import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = parseInt(br.readLine());
        List<Pair> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = parseInt(st.nextToken());
            int end = parseInt(st.nextToken());

            if (start > end) {
                int temp = start;
                start = end;
                end = temp;
            }

            arr.add(new Pair(start, end));
        }


        Collections.sort(arr);

        int length = parseInt(br.readLine());
        int result = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Pair pair : arr) {
            if (pair.end - pair.start > length) {
                continue;
            }

            while (!pq.isEmpty() && pq.peek() < pair.end - length) {
                pq.poll();
            }

            pq.add(pair.start);

            result = Math.max(result, pq.size());
        }

        System.out.println(result);
    }

    static class Pair implements Comparable<Pair> {
        int start;
        int end;

        Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Pair o) {
            return this.end - o.end;
        }
    }
}