
import java.io.*;
import java.util.Stack;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        bw.write(getArea(N) + "\n");
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