import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 마을의 개수
        int C = Integer.parseInt(st.nextToken()); // 최대 용량
        int M = Integer.parseInt(br.readLine()); // 정보의 수
        Tuple[] arr = new Tuple[M];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());
            arr[i] = new Tuple(start, end, cnt);
        }

        Arrays.sort(arr);

        int[] weights = new int[N + 1];
        for(int i = 1; i <= N; i++)
            weights[i] = C;

        int result = 0;
        for(int i = 0; i < M; i++){
            Tuple tuple = arr[i];
            int max = Integer.MAX_VALUE;

            for(int j = tuple.start; j <= tuple.end; j++)
                max = Math.min(max, weights[j]);

            if(max >= tuple.capacity){
                for(int j = tuple.start; j <= tuple.end; j++){
                    weights[j] -= tuple.capacity;
                }
                result += tuple.capacity;
            }else{
                for(int j = tuple.start; j <= tuple.end; j++){
                    weights[j] -= max;
                }
                result += max;
            }
        }
        
        bw.write(result +"\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static class Tuple implements Comparable<Tuple>{
        int start, end, capacity;
        Tuple(int start, int end, int capacity){
            this.start = start;
            this.end = end;
            this.capacity = capacity;
        }

        @Override
        public int compareTo(Tuple o) {
            if(this.end == o.end){
                return this.start - o.start;
            }
            return this.end - o.end;
        }
    }
}