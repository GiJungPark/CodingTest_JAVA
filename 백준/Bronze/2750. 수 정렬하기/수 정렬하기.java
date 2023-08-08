import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        
        int N = sc.nextInt();
        int[] A = new int[N];
        for(int i = 0; i < N; i++){
            A[i] = sc.nextInt();
        }
        
        Arrays.sort(A);
        
        for(int i = 0; i < N; i++){
            sb.append(A[i] + "\n");
        }

        System.out.println(sb.toString());
    }
}