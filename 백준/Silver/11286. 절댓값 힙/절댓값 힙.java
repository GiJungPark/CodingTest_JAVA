import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                ((o1, o2) -> {
                    if(Math.abs(o1) == Math.abs(o2)){
                        return o1 > o2 ? 1 : -1;
                    }else{
                        return Math.abs(o1) - Math.abs(o2);
                    }
                })
        );

        for(int i = 0; i < N; i++){
            int step = Integer.parseInt(br.readLine());
            if(step != 0){
                pq.offer(step);
            }else{
                if(!pq.isEmpty()){
                    sb.append(pq.poll()+"\n");
                }else{
                    sb.append("0\n");
                }
            }
        }
        System.out.println(sb.toString());
    }
}