import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Pair[] list = new Pair[N];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list[i] = new Pair(start, end);
        }
        
        Arrays.sort(list);
        
        pq.offer(list[0].E);

        for(int i = 1; i < N; i++){
            if(list[i].S >= pq.peek()) {
                pq.poll();
            }
            pq.offer(list[i].E);
        }
        System.out.println(pq.size());
    }

    static class Pair implements Comparable<Pair>{
        int S;
        int E;
        Pair(int S, int E){
            this.S = S;
            this.E = E;
        }

        @Override
        public int compareTo(Pair o) {
            if(S == o.S){
                return E - o.E;
            }
            return S - o.S;
        }
    }
}