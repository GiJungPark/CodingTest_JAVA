import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        long min = sc.nextLong();
        long max = sc.nextLong();

        boolean[] A = new boolean[(int)(max - min + 1)];

        //에라토스테네스의 체 변형
        for(long i = 2; i * i <= max; i++){
            long pow = i * i;
            long start_idx = min / pow;
            if(min % pow != 0) start_idx++;
            for(long j = start_idx; pow * j <= max; j++){
                A[(int)((j * pow) - min)] = true;
            }
        }

        int result = 0;
        for(int i = 0; i <= max - min; i++){
            if(A[i] == true) continue;
            result++;
        }

        System.out.println(result);
    }
}