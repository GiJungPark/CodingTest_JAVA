import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int result = 0;

        Integer[] A = new Integer[N];
        for(int i = 0; i < N; i++){
            A[i] = sc.nextInt();
        }

        Arrays.sort(A, Collections.reverseOrder());

        for(Integer i : A){
            while(i <= K){
                K -= i;
                result++;
            }
        }

        System.out.println(result);
    }
}