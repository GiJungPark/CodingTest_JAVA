import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int result = 0;

        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int startIdx = 0;
        int endIdx = N - 1;
        while(arr[startIdx] < arr[endIdx]){
            int step = arr[startIdx] + arr[endIdx];
            if(step == M){
                result++;
                startIdx++;
                endIdx--;
            }else if(step > M){
                endIdx--;
            }else{
                startIdx++;
            }
        }

        System.out.println(result);
    }
}