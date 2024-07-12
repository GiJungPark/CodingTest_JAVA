import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Main {

    static int N;
    static boolean[][] map;
    static Map<Integer, String> timeLine;
    static int[] dx = {1, 0, -1 ,0};
    static int[] dy = {0, 1, 0, -1};


    public static void main(String[] args) throws IOException {
        init();
        snakeGame();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = parseInt(br.readLine());
        int K = parseInt(br.readLine());

        map = new boolean[N + 1][N + 1];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int y = parseInt(st.nextToken());
            int x = parseInt(st.nextToken());

            map[x][y] = true;
        }

        int L = parseInt(br.readLine());
        timeLine = new HashMap<>();
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int time = parseInt(st.nextToken());
            String direction = st.nextToken();
            timeLine.put(time, direction);
        }
    }

    static void snakeGame() {
        int x = 1;
        int y = 1;
        int d = 0;
        int time = 0;
        Deque<Pair> queue = new LinkedList<>();
        queue.add(new Pair(x, y));

        while(true) {
            time++;

            // 다음 좌표 설정
            x += dx[d];
            y += dy[d];

            // 벽에 충돌한 경우
            if (x < 1 || y < 1 || x > N || y > N) {
                break;
            }

            Pair head = new Pair(x, y);

            // 자신 몸에 맞닿은 경우
            if (queue.contains(head)) {
                break;
            }
            // 몸에 맞닿지 않는 경우
            else {
                queue.addFirst(head);
            }

            // 사과가 없다면 맨 뒤 꼬리 제거
            if (!map[x][y]) {
                queue.removeLast();
            }
            // 사과가 있다면 사과 지우기
            else {
                map[x][y] = false;
            }


            // 방향 설정
            if (timeLine.containsKey(time)) {
                String direction = timeLine.get(time);
                if (direction.equals("D")) {
                    d += 1;
                    if (d > 3) {
                        d = 0;
                    }
                }
                else if (direction.equals("L")) {
                    d -= 1;
                    if (d < 0) {
                        d = 3;
                    }
                }
            }
        }

        System.out.println(time);
    }

    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
