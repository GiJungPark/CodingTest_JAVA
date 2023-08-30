import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            if(N == 0) break;

            arr = new int[N];
            for(int i = 0; i < N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            bw.write(getArea(N) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static long getArea(int N) {
        Stack<Integer> stack = new Stack<>();
        long maxArea = 0;
        for(int i = 0; i < N; i++){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                int height = arr[stack.pop()];
                long width = stack.isEmpty() ? i : i - 1 - stack.peek();

                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            int height = arr[stack.pop()];
            long width = stack.isEmpty() ? N : N - 1 - stack.peek();

            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }
}