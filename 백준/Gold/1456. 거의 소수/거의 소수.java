import java.util.Scanner;

public class Main {
    private static final int MAX_SIZE = 10000001;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long min = sc.nextLong();
        long max = sc.nextLong();

        //배열 생성
        long[] A = new long[MAX_SIZE];
        for(int i = 2; i < MAX_SIZE; i++){
            A[i] = i;
        }

        //에라토스테네스의 체
        for(int i = 2; i < Math.sqrt(MAX_SIZE); i++){
            if(A[i] == 0) continue;
            for(int j = i + i; j < MAX_SIZE; j += i){
                A[j] = 0;
            }
        }

        //min <= A[i] ^ n <= max
        //min / A[i]^(n-1) <= A[i] <= max / A[i]^(n-1)
        //min과 max의 범위가 너무 크기 때문에 A[i]의 n-1승 만큼 나누어서 비교 진행
        int result = 0;
        for(int i = 2; i < MAX_SIZE; i++){
            if(A[i] == 0) continue;
            long temp = A[i];
            while((double)A[i] <= (double)max / (double)temp){
                if((double)A[i] >= (double)min / (double)temp) result++;
                temp *= A[i];
            }
        }

        System.out.println(result);
    }
}
