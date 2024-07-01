import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Main {

    private static ArrayList<Node>[] graph;
    private static int[] dist;
    private static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = parseInt(st.nextToken());
        M = parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        dist = new int[N + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int startIdx = parseInt(st.nextToken());
            int endIdx = parseInt(st.nextToken());
            int value = parseInt(st.nextToken());

            // 양방향 그래프
            graph[startIdx].add(new Node(endIdx, value));
            graph[endIdx].add(new Node(startIdx, value));
        }

        dijkstra(1);

        System.out.println(dist[N]);

    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()) {
            Node currentNode = pq.poll();
            for (Node nextNode : graph[currentNode.idx]) {
                if (dist[nextNode.idx] > dist[currentNode.idx] + nextNode.value) {
                    dist[nextNode.idx] = dist[currentNode.idx] + nextNode.value;
                    pq.add(new Node(nextNode.idx, dist[nextNode.idx]));
                }
            }
        }

    }

    static class Node implements Comparable<Node> {
        int idx, value;

        Node(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }
}
