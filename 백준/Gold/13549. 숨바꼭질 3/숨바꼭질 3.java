import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Main {

    private static int MAX_VALUE = 100000;
    private static int[] arr = new int[MAX_VALUE + 1];
    private static Queue<Pair> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = parseInt(st.nextToken());
        int end = parseInt(st.nextToken());

        if (start >= end) {
            System.out.println(start - end);
        } else {
            BFS(start);
            System.out.println(arr[end]);
        }
    }

    public static void BFS(int start) {
        Arrays.fill(arr, MAX_VALUE);
        arr[start] = 0;
        queue.add(new Pair(start, 0));

        while (!queue.isEmpty()) {
            Pair pair = queue.remove();

            int point1 = pair.position - 1;
            if (isValid(point1) && arr[point1] > pair.time + 1) {
                arr[point1] = pair.time + 1;
                queue.add(new Pair(point1, arr[point1]));
            }

            int point2 = pair.position + 1;
            if (isValid(point2) && arr[point2] > pair.time + 1) {
                arr[point2] = pair.time + 1;
                queue.add(new Pair(point2, arr[point2]));
            }

            int point3 = pair.position * 2;
            if (isValid(point3) && arr[point3] > pair.time) {
                arr[point3] = pair.time;
                queue.add(new Pair(point3, arr[point3]));
            }
        }

    }

    public static boolean isValid(int num) {
        return num >= 0 && num <= MAX_VALUE;
    }

    public static class Pair {
        int position;
        int time;

        Pair(int position, int time) {
            this.position = position;
            this.time = time;
        }
    }
}
