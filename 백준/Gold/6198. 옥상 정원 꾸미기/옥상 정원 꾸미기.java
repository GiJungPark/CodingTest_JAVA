    import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(br.readLine());
        }

        long result = 0;
        for(int i = 0; i < N; i++){
            //자신이 위치한 빌딩보다 높거나 같은 빌딩이 있으면 그 다음에 있는 모든 빌딩의 옥상은 보지 못한다.
            while(!stack.isEmpty() && stack.peek() <= A[i]){
                stack.pop();
            }
            stack.push(A[i]);
            result += stack.size() - 1;
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}