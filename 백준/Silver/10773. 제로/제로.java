import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < N; i++){
            int tmp = Integer.parseInt(br.readLine());
            if(tmp == 0){
                stack.pop();
            }else{
                stack.push(tmp);
            }
        }

        int sum = 0;
        while(!stack.isEmpty()){
            sum += stack.pop();
        }

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}