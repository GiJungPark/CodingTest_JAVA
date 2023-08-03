import java.util.PriorityQueue;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int size = enemy.length;
        for(int round = 0; round < size; round++){
            pq.add(enemy[round]);
            if(pq.size() > k){
                n -= pq.poll();
            }
            if(n < 0) return round;
        }
        return size;
    }
}