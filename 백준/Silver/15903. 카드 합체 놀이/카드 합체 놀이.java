import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //카드의 개수
        int M = sc.nextInt(); //merge 횟수
        PriorityQueue<Long> pq = new PriorityQueue<>(); //카드 덱

        //카드 덱에 카드 넣기
        for(int i = 0; i < N; i++){
            pq.offer(sc.nextLong());
        }

        //카드 merge 수행
        for(int i = 0; i < M; i++){
            long firstValue = pq.poll();
            long secondValue = pq.poll();
            pq.offer(firstValue + secondValue);
            pq.offer(firstValue + secondValue);
        }

        //카드 덱의 전체 합 구하기
        long sum = 0;
        while(!pq.isEmpty()){
            sum += pq.poll();
        }

        System.out.println(sum);
    }
}