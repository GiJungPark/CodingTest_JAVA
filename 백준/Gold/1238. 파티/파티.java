import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = parseInt(st.nextToken());
        int M = parseInt(st.nextToken());
        int X = parseInt(st.nextToken());

        ArrayList<Node>[] graph = new ArrayList[N + 1];
        ArrayList<Node>[] reverseGraph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = parseInt(st.nextToken());
            int end = parseInt(st.nextToken());
            int cost = parseInt(st.nextToken());
            graph[start].add(new Node(end, cost));
            reverseGraph[end].add(new Node(start, cost));
        }

        int[] dist = new int[N + 1];
        int[] reverseDist = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            dist[i] = MAX_VALUE;
            reverseDist[i] = MAX_VALUE;
        }

        dijkstra(dist, graph, X);
        dijkstra(reverseDist, reverseGraph, X);

        int max = 0;
        for (int i = 1; i <= N; i++) {
            if (max < dist[i] + reverseDist[i]) max = dist[i] + reverseDist[i];
        }

        System.out.println(max);

    }

    public static void dijkstra(int[] dist, ArrayList<Node>[] graph, int idx) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(idx, 0));
        dist[idx] = 0;

        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();

            if (dist[currentNode.idx] < currentNode.cost) {
                continue;
            }

            for (int i = 0; i < graph[currentNode.idx].size(); i++) {
                Node nextNode = graph[currentNode.idx].get(i);

                if (dist[nextNode.idx] > currentNode.cost + nextNode.cost) {
                    dist[nextNode.idx] = currentNode.cost + nextNode.cost;
                    pq.offer(new Node(nextNode.idx, dist[nextNode.idx]));
                }

            }
        }
    }

    public static class Node implements Comparable<Node> {
        int idx;
        int cost;

        Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
