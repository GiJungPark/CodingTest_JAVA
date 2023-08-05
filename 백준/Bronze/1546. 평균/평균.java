import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long sum = 0;
        int max = 0;

        for(int i = 0; i < N; i++){
           int num = sc.nextInt();
           if(num > max) max = num;
           sum += num;
        }

        System.out.print(sum * 100.0 / max / N);
    }
}