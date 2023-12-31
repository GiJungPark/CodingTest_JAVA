import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] A, tmp;
    public static long result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new int[N+1];
        tmp = new int[N+1];
        result = 0;

        for(int i = 1; i <= N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        merget_sort(1, N);

        System.out.println(result);
    }

    public static void merget_sort(int s, int e){
        if(e - s < 1) return;
        int m = s + (e - s) / 2;
        merget_sort(s, m);
        merget_sort(m+1, e);
        for(int i = s; i <= e; i++){
            tmp[i] = A[i];
        }

        int k = s;
        int idx1 = s;
        int idx2 = m+1;
        while(idx1 <= m && idx2 <= e){
            if(tmp[idx1] > tmp[idx2]){
                result += idx2 - k;
                A[k] = tmp[idx2];
                k++;
                idx2++;
            } else {
                A[k] = tmp[idx1];
                k++;
                idx1++;
            }
        }

        while(idx1 <= m){
            A[k] = tmp[idx1];
            k++;
            idx1++;
        }

        while(idx2 <= e){
            A[k] = tmp[idx2];
            k++;
            idx2++;
        }
    }
}