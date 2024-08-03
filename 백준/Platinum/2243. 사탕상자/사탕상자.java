import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Main {

    static final int SIZE = 1_000_001;
    static int[] segmentTree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = parseInt(br.readLine());
        segmentTree = new int[SIZE * 4];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int A = parseInt(st.nextToken());
            int B = parseInt(st.nextToken());
            // Candy Update
            if (A == 2) {
                int C = parseInt(st.nextToken());
                update(1, SIZE, 1, B, C);
            }
            // Search Candy
            else if (A == 1) {
                sb.append(search(1, SIZE, 1, B)).append("\n");
            }
        }

        System.out.println(sb);
    }

    static void update(int start, int end, int node, int index, int diff) {
        if (start > index || index > end) {
            return;
        }

        segmentTree[node] += diff;

        if (start == end) {
            return;
        }

        int mid = (start + end) / 2;
        update(start, mid, node * 2, index, diff);
        update(mid + 1, end, node * 2 + 1, index, diff);
    }

    static int search(int start, int end, int node, int target) {
        if (start == end) {
            update(1, SIZE, 1, start, -1);
            return start;
        }

        int mid = (start + end) / 2;
        if (segmentTree[node * 2] >= target) {
            return search(start, mid, node * 2, target);
        }
        else {
            return search(mid + 1, end, node * 2 + 1, target - segmentTree[node * 2]);
        }
    }
}
