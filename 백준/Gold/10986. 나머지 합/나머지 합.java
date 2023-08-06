import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        long result = 0;

        long[] arr = new long[N];
        long[] countArr = new long[M];

        for(int i = 0; i < N; i++) {
            if(i == 0) {
                arr[i] = sc.nextInt();
                continue;
            }
            arr[i] = sc.nextInt() + arr[i-1];
        }

        for(int i = 0; i < N; i++){
            int step = (int)(arr[i] % M);
            if(step == 0) result++;
            countArr[step]++;
        }

        for(int i = 0; i < M; i++){
            if(countArr[i] > 1) {
                result += (countArr[i] * (countArr[i] - 1)) / 2;
            }
        }

        System.out.println(result);
    }
}