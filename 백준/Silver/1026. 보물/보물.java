import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        PriorityQueue<Integer> reverseQueue = new PriorityQueue<>(Collections.reverseOrder());
        StringTokenizer A = new StringTokenizer(br.readLine());
        StringTokenizer B = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            queue.offer(Integer.parseInt(A.nextToken()));
            reverseQueue.offer(Integer.parseInt(B.nextToken()));
        }

        int result = 0;
        for(int i = 0; i < N; i++){
            result += queue.poll() * reverseQueue.poll();
        }

        System.out.println(result);
    }
}