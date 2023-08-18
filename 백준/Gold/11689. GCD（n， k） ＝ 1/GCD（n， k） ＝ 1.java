import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        long result = N;
        
        for(int i = 2; i <= Math.sqrt(N); i++){
            if(N % i == 0) {
                result -= result / i;
                while(N % i == 0){
                    N /= i;
                }
            }
        }
        
        // 제곱근까지 탐색했으므로, 1개의 소인수가 누락된 케이스
        if(N > 1){
            result -= result / N;
        }

        System.out.println(result);
    }
}