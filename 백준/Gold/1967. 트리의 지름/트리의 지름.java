import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Main {

    private static ArrayList<Node>[] graph;
    private static int[] dist;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = parseInt(st.nextToken());
            int end = parseInt(st.nextToken());
            int value = parseInt(st.nextToken());

            graph[start].add(new Node(end, value));
            graph[end].add(new Node(start, value));
        }

        dist = new int[N + 1];
        visited = new boolean[N + 1];
        bfs(1);
        int max = 0;
        int maxIdx = 0;
        for (int i = 0; i < dist.length; i++) {
            if (max < dist[i]) {
                max = dist[i];
                maxIdx = i;
            }
        }

        dist = new int[N + 1];
        visited = new boolean[N + 1];
        bfs(maxIdx);
        int result = 0;
        for (int i = 0; i < dist.length; i++) {
            if (result < dist[i]) {
                result = dist[i];
            }
        }

        System.out.println(result);
    }

    public static void bfs(int idx) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(idx, 0));
        dist[idx] = 0;

        while(!queue.isEmpty()) {
            Node current = queue.poll();

            if (visited[current.idx]) {
                continue;
            }

            visited[current.idx] = true;

            for (int i = 0; i < graph[current.idx].size(); i++) {
                Node next = graph[current.idx].get(i);

                if (!visited[next.idx]) {
                    dist[next.idx] = dist[current.idx] + next.cost;
                    queue.offer(new Node(next.idx, dist[next.idx]));
                }
            }

        }
    }

    public static class Node {
        int idx;
        int cost;

        Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
}
