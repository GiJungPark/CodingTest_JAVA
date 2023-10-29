
import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    private static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    private static PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if(maxHeap.size() == minHeap.size()) {
                maxHeap.add(num);

                if(!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(minHeap.poll());
                }

            } else {
                minHeap.add(num);

                if (maxHeap.peek() > minHeap.peek()) {
                    maxHeap.add(minHeap.poll());
                    minHeap.add(maxHeap.poll());
                }
            }

            bw.write(maxHeap.peek() + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}