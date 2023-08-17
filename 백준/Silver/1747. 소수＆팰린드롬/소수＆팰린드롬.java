import java.util.Scanner;

public class Main {
    private static final int MAX = 10000001;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] A = new int[MAX];
        for(int i = 2; i < MAX; i++){
            A[i] = i;
        }

        //에라토스테네스의 체
        for(int i = 2; i < Math.sqrt(MAX); i++){
            if(A[i] == 0) continue;
            for(int j = i + i; j < MAX; j += i){
                A[j] = 0;
            }
        }
        
        for(int i = N; i < MAX; i++){
            if(A[i] == 0) continue;
            if(isPalindrome(A[i])) {
                System.out.println(A[i]);
                break;
            }
        }
    }

    //팰린드롬 확인 함수
    private static boolean isPalindrome(int target){
        char[] step = String.valueOf(target).toCharArray();
        int S = 0;
        int E = step.length - 1;
        while(S < E){
            if(step[S] != step[E]) return false;
            S++;
            E--;
        }
        return true;
    }
}