
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 1, 0};
    static int[] vistied;
    static int[] idxMap;
    static int N, K;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        vistied = new int[100001];
        idxMap = new int[100001];

        if(N == K){
            bw.write(0 + "\n");
            bw.write(N + "\n");
        }else {
            bfs(N);
            bw.write(vistied[K] + "\n");

            Stack<Integer> stack = new Stack<>();
            int idx = K;
            while (idx != N) {
                stack.push(idx);
                idx = idxMap[idx];
            }
            stack.push(idx);


            while (!stack.isEmpty())
                bw.write(stack.pop() + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int i = 0; i < 3; i++){
                int next;
                if(dx[i] == 0){
                    next = now * 2;
                }else{
                    next = now + dx[i];
                }

                if(next < 0 || next > 100000 || vistied[next] != 0)
                    continue;

                queue.offer(next);
                vistied[next] = vistied[now] + 1;
                idxMap[next] = now;

                if(vistied[K] != 0) return;
            }
        }
    }
}
