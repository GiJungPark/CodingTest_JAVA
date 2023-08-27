import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(A);

        int max = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = A.length - 1; i >= 0; i--){
            pq.offer(A[i]);
            int tmp = pq.peek() * pq.size();
            max = tmp > max ? tmp : max;
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}