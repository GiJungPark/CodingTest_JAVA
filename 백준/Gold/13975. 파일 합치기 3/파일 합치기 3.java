
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        // 테스트 케이스 반복
        for(int t = 0; t < T; t++){
            int K = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            PriorityQueue<Long> pq = new PriorityQueue<>();
            for(int i = 0; i < K; i++){
                pq.offer(Long.parseLong(st.nextToken()));
            }


            long sum = 0;
            while(pq.size() > 1){
                long firstValue = pq.poll();
                long secondValue = pq.poll();
                sum += firstValue + secondValue;
                pq.offer(firstValue + secondValue);
            }

            bw.write(sum + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}