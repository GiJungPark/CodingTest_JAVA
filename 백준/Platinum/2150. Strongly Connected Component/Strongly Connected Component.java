import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.util.Comparator.*;

public class Main {

    static int index, sccCount = 0;
    static List<Integer>[] list;
    static int[] discovery, sccId;
    static Stack<Integer> stack;
    static List<Queue<Integer>> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = parseInt(st.nextToken());
        int e = parseInt(st.nextToken());

        list = new ArrayList[v + 1];
        discovery = new int[v + 1];
        sccId = new int[v + 1];

        for (int i = 0; i <= v; i++) {
            list[i] = new ArrayList<>();
            discovery[i] = -1;
            sccId[i] = -1;
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = parseInt(st.nextToken());
            int b = parseInt(st.nextToken());

            list[a].add(b);
        }

        stack = new Stack<>();
        result = new ArrayList<>();

        for (int i = 1; i <= v; i++) {
            if (discovery[i] == -1) {
                scc(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(sccCount).append("\n");
        Collections.sort(result, comparingInt(Queue::peek));

        for (Queue queue : result) {
            while(!queue.isEmpty()) {
                sb.append(queue.poll()).append(" ");
            }
            sb.append(-1).append("\n");
        }

        System.out.println(sb);
    }

    private static int scc(int current) {
        discovery[current] = index++;
        stack.push(current);

        int ret = discovery[current];
        for (int next : list[current]) {
            if (discovery[next] == -1) {
                ret = Math.min(ret, scc(next));
            } else if (sccId[next] == -1) {
                ret = Math.min(ret, discovery[next]);
            }
        }

        if (ret == discovery[current]) {
            Queue<Integer> queue = new PriorityQueue<>();
            while (true) {
                int temp = stack.pop();
                queue.add(temp);
                sccId[temp] = sccCount;

                if (temp == current) {
                    break;
                }
            }

            result.add(queue);
            sccCount++;
        }

        return ret;
    }
}