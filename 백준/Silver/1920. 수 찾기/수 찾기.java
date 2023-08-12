import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            boolean flag = false;
            int step = Integer.parseInt(st.nextToken());
            int start = 0;
            int end = N - 1;
            while(start <= end){
                int mid = (start + end) / 2;
                int midV = A[mid];
                if(midV < step){
                    start = mid + 1;
                }else if(midV > step){
                    end = mid - 1;
                }else{
                    flag = true;
                    break;
                }
            }
            if(flag){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }
    }
}