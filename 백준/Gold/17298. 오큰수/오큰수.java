import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] result = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i = 1; i < N; i++){
            while(!stack.isEmpty() && A[i] > A[stack.peek()]){
                result[stack.pop()] = A[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            result[stack.pop()] = -1;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < N; i++){
            bw.write(result[i] + " ");
        }
        bw.flush();
    }
}