import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt() + 1;
        int N = sc.nextInt();

        int[] sumArr = new int[size];
        for(int k = 1; k < size; k++){
            sumArr[k] = sumArr[k-1] + sc.nextInt();
        }

        for(int j = 0; j < N; j++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(sumArr[b] - sumArr[a - 1]);
        }
    }
}