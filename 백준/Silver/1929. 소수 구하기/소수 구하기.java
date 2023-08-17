import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        int[] A = new int[N+1];
        for(int i = 2; i <= N; i++){
            A[i] = i;
        }

        for(int i = 2; i <= N; i++){
            if(A[i] == 0) continue;
            if(A[i] >= M) System.out.println(A[i]);
            int step = 2;
            while(i * step <= N){
                A[i * step] = 0;
                step++;
            }
        }
    }
}