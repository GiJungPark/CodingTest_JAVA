import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        long start = 1, end = K;
        long ans = 0;

        while(start <= end){
            long mid = (start + end) / 2;
            int count = 0;
            for(int i = 1; i <= N; i++){
                count += Math.min(mid / i, N);
            }
            if(count < K){
                start = mid + 1;
            }else{
                ans = mid;
                end = mid - 1;
            }
        }
        System.out.println(ans);
    }
}