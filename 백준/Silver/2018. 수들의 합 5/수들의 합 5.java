import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int result = 0;
        int idx = 1;
        int endIdx = 1;
        int sum = 1;

        while(endIdx <= N){
            if(sum == N){
                result++;
                idx++;
                endIdx = idx;
                sum = 0;
            }else if(sum < N){
                endIdx++;
                sum += endIdx;
            }else{
                idx++;
                endIdx = idx;
                sum = idx;
            }
        }

        System.out.println(result);
    }
}