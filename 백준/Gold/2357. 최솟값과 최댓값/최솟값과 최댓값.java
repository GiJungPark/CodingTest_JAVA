
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;
import static java.lang.Integer.parseInt;

public class Main {

    static int[] arr, min, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = parseInt(st.nextToken());
        int M = parseInt(st.nextToken());

        // 배열 생성
        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = parseInt(br.readLine());
        }

        // 구간 별 최소 값 정렬
        min = new int[N * 4];
        minInit(1, N, 1);

        // 구간 별 최대 값 정렬
        max = new int[N * 4];
        maxInit(1, N, 1);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = parseInt(st.nextToken());
            int end = parseInt(st.nextToken());
            int minResult = findMin(1, N, 1, start, end);
            int maxResult = findMax(1, N, 1, start, end);
            result.append(minResult).append(" ").append(maxResult).append("\n");
        }

        System.out.println(result);

    }

    static int minInit(int start, int end, int node) {
        if (start == end) {
            return min[node] = arr[start];
        }

        int mid = (start + end) / 2;
        return min[node] = Math.min(minInit(start, mid, node * 2), minInit(mid + 1, end, node * 2 + 1));
    }

    static int maxInit(int start, int end, int node) {
        if (start == end) {
            return max[node] = arr[start];
        }

        int mid = (start + end) / 2;
        return max[node] = Math.max(maxInit(start, mid, node * 2), maxInit(mid + 1, end, node * 2 + 1));
    }

    static int findMin(int start, int end, int node, int left, int right) {
        if (right < start || end < left) {
            return MAX_VALUE;
        }

        if (left <= start && end <= right) {
            return min[node];
        }

        int mid = (start + end) / 2;
        return Math.min(findMin(start, mid, node * 2, left, right), findMin(mid + 1, end, node * 2 + 1, left, right));
    }

    static int findMax(int start, int end, int node, int left, int right) {
        if (right < start || end < left) {
            return MIN_VALUE;
        }

        if (left <= start && end <= right) {
            return max[node];
        }

        int mid = (start + end) / 2;
        return Math.max(findMax(start, mid, node * 2, left, right), findMax(mid + 1, end, node * 2 + 1, left, right));

    }
}
