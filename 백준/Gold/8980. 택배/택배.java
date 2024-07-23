
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = parseInt(st.nextToken()); // 마을 수
        int C = parseInt(st.nextToken()); // 저장 공간 수
        int M = parseInt(br.readLine()); // 박스 수

        List<Box> boxes = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = parseInt(st.nextToken());
            int end = parseInt(st.nextToken());
            int capacity = parseInt(st.nextToken());
            boxes.add(new Box(start, end, capacity));
        }

        Collections.sort(boxes);
        int[] arr = new int[N + 1];

        int result = 0;
        for (int i = 0; i < M; i++) {
            Box box = boxes.get(i);
            int start = box.start;
            int end = box.end;
            int capacity = box.capacity;

            int max = capacity;
            for (int j = start; j < end; j++) {
                if (arr[j] + capacity > C) {
                    max = Math.min(max, C - arr[j]);
                }
//
//                if (arr[j] + capacity <= C) {
//                    arr[j] += capacity;
//                }
            }

            if (max > 0) {
                for (int j = start; j < end; j++) {
                    arr[j] += max;
                }
                result += max;
            }
        }

        System.out.println(result);
    }

    static class Box implements Comparable<Box> {
        int start, end, capacity;

        Box(int start, int end, int capacity) {
            this.start = start;
            this.end = end;
            this.capacity = capacity;
        }

        @Override
        public int compareTo(Box o) {
            if (this.end == o.end) {
                return this.start - o.start;
            }

            return this.end - o.end;
        }
    }
}
