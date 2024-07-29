import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Main {

    static int N;
    static int[] arr;
    static int[][] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = parseInt(br.readLine());
        arr = new int[N + 1];
        tree = new int[4 * N][2];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = parseInt(st.nextToken());
        }

        initTree(1, N, 1);

        StringBuilder sb = new StringBuilder();
        int M = parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int val = parseInt(st.nextToken());
            int a = parseInt(st.nextToken());
            int b = parseInt(st.nextToken());

            // a값을 b로 변경
            if (val == 1) {
                updateTree(1, N, 1, a, b);
                continue;
            }

            // 인덱스 범위중 가장 작은 값 출력
            sb.append(searchTree(1, N, 1, a, b)[1]).append("\n");
        }

        System.out.println(sb);
    }

    static void initTree(int start, int end, int node) {
        if (start == end) {
            tree[node][0] = arr[start];
            tree[node][1] = start;
            return;
        }

        int mid = (start + end) / 2;
        initTree(start, mid, node * 2);
        initTree(mid + 1, end, node * 2 + 1);
        tree[node] = minIndex(tree[node * 2], tree[node * 2 + 1]);
    }

    static int[] searchTree(int start, int end, int node, int left, int right) {
        if (left > end || right < start) {
            return new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        }

        if (left <= start && end <= right) {
            return tree[node];
        }

        int mid = (start + end) / 2;
        int[] leftMin = searchTree(start, mid, node * 2, left, right);
        int[] rightMin = searchTree(mid + 1, end, node * 2 + 1, left, right);
        return minIndex(leftMin, rightMin);
    }

    static void updateTree(int start, int end, int node, int index, int value) {
        if (index < start || end < index) {
            return;
        }

        if (start == end) {
            arr[index] = value;
            tree[node][0] = value;
            tree[node][1] = index;
            return;
        }

        int mid = (start + end) / 2;
        updateTree(start, mid, node * 2, index, value);
        updateTree(mid + 1, end, node * 2 + 1, index, value);
        tree[node] = minIndex(tree[node * 2], tree[node * 2 + 1]);
    }

    static int[] minIndex(int[] a, int[] b) {
        if (a[0] < b[0] || (a[0] == b[0] && a[1] < b[1])) {
            return a;
        } else {
            return b;
        }
    }
}