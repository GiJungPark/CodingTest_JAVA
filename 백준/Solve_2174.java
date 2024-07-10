package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Solve_2174 {

    private static final String RESULT_WALL = "Robot %d crashes into the wall";
    private static final String RESULT_ROBOT = "Robot %d crashes into robot %d";
    private static final String RESULT_OK = "OK";
    private static boolean[][] map;
    private static int A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        A = parseInt(st.nextToken());
        B = parseInt(st.nextToken());
        map = new boolean[B + 1][A + 1];

        st = new StringTokenizer(br.readLine());
        int N = parseInt(st.nextToken());
        int M = parseInt(st.nextToken());

        Robot[] robots = new Robot[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = parseInt(st.nextToken());
            int y = parseInt(st.nextToken());
            String direction = st.nextToken();
            robots[i] = new Robot(i, x, y, direction);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int robotNum = parseInt(st.nextToken());
            String method = st.nextToken();
            int methodNum = parseInt(st.nextToken());

            for (int num = 0; num < methodNum; num++) {
                if (!robots[robotNum].method(method, robots)) {
                    return;
                }
            }
        }

        System.out.println(RESULT_OK);
    }

    static class Robot {
        int idx, x, y;
        String direction;

        public Robot(int idx, int x, int y, String direction) {
            this.idx = idx;
            this.x = x;
            this.y = y;
            this.direction = direction;
            map[y][x] = true;
        }

        public boolean method(String value, Robot[] robots) {
            map[y][x] = false;
            if (value.equals("L")) {
                methodL();
            } else if (value.equals("R")) {
                methodR();
            } else {
                if (!methodF(robots)) {
                    return false;
                }
            }

            if (x < 1 || y < 1 || x > A || y > B) {
                System.out.printf(RESULT_WALL, idx);
                return false;
            }

            if (map[y][x]) {
                for (Robot robot : robots) {
                    if (robot != null && robot.x == x && robot.y == y && robot.idx != idx) {
                        System.out.printf(RESULT_ROBOT, idx, robot.idx);
                        return false;
                    }
                }
            }

            map[y][x] = true;
            return true;
        }

        public void methodL() {
            switch (this.direction) {
                case "N": this.direction = "W"; break;
                case "W": this.direction = "S"; break;
                case "S": this.direction = "E"; break;
                case "E": this.direction = "N"; break;
            }
        }

        public void methodR() {
            switch (this.direction) {
                case "N": this.direction = "E"; break;
                case "W": this.direction = "N"; break;
                case "S": this.direction = "W"; break;
                case "E": this.direction = "S"; break;
            }
        }

        public boolean methodF(Robot[] robots) {
            switch (this.direction) {
                case "N": this.y += 1; break;
                case "W": this.x -= 1; break;
                case "S": this.y -= 1; break;
                case "E": this.x += 1; break;
            }

            // Check for wall collision
            if (this.x < 1 || this.y < 1 || this.x > A || this.y > B) {
                System.out.printf(RESULT_WALL, this.idx);
                return false;
            }

            // Check for robot collision
            for (Robot robot : robots) {
                if (robot != null && robot.idx != this.idx && robot.x == this.x && robot.y == this.y) {
                    System.out.printf(RESULT_ROBOT, this.idx, robot.idx);
                    return false;
                }
            }

            return true;
        }
    }
}