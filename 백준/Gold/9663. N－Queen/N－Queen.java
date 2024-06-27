import java.util.Scanner;

public class Main {

    private static int[] Arr;
    private static int N;
    private static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        Arr = new int[N + 1];
        nQueen(1);

        System.out.println(count);
    }

    public static void nQueen(int depth) {

        if (depth == N + 1) {
            count++;
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (isAvailable(i, depth)) {
                Arr[depth] = i;
                nQueen(depth + 1);
                Arr[depth] = 0;
            }
        }
    }

    public static boolean isAvailable(int num, int depth) {
        for (int i = 1; i <= depth - 1; i++) {
            // 직선으로 위치하는 경우
            if (Arr[i] == num) {
                return false;
            }

            // 대각선으로 위치하는 경우
            if (Math.abs(depth - i) == Math.abs(num - Arr[i])) {
                return false;
            }
        }

        return true;
    }
}