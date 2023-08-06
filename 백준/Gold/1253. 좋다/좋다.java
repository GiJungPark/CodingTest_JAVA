import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());

        long[] arr = new long[N];
        for(int i = 0; i < N; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        int result = 0;
        for(int i = 0; i < N; i++){
            long find = arr[i];
            int start = 0;
            int end = N-1;
            while(start < end){
                long step = arr[start] + arr[end];
                if(step == find){
                    if(i != start && i != end){
                        result++;
                        break;
                    }else if(i == start){
                        start++;
                    }else{
                        end--;
                    }
                }else if(step > find){
                    end--;
                }else{
                    start++;
                }
            }
        }
        System.out.println(result);
    }
}