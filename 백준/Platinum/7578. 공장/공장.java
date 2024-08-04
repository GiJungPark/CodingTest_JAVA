import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Main {

    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = parseInt(br.readLine());

        int[] A = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = parseInt(st.nextToken());
        }

        Map<Integer, Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int value = parseInt(st.nextToken());
            map.put(value, i);
        }

        long result = 0;
        tree = new long[(N + 1) * 4];
        for (int i = 1; i <= N; i++) {
            int valueA = A[i];
            int valueB = map.get(valueA);

            result += treeSum(1, N, 1, valueB + 1, N);

            update(1, N, 1, valueB, 1);
        }

        System.out.println(result);
    }

    static long treeSum(int start, int end, int node, int left, int right) {
        if (left > end || right < start) {
            return 0;
        }

        if (left <= start && end <= right) {
            return tree[node];
        }

        int mid = (start + end) / 2;
        return treeSum(start, mid, node * 2, left, right) + treeSum(mid + 1, end, node * 2 + 1, left, right);
    }

    static void update(int start, int end, int node, int index, int diff) {
        if (index < start || index > end) {
            return;
        }

        tree[node] += diff;

        if (start != end ) {
            int mid = (start + end) / 2;
            update(start, mid, node * 2, index, diff);
            update(mid + 1, end, node * 2 + 1, index, diff);
        }
    }
}