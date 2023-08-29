import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st =new StringTokenizer(br.readLine());
        Stack<Top> stack = new Stack<>();

        for(int i = 1; i <= N; i++){
            int tmp = Integer.parseInt(st.nextToken());
            while(!stack.isEmpty() && stack.peek().height <= tmp){
                stack.pop();
            }
            if(stack.size() == 0){
                bw.write(0 + " ");
            }else{
                bw.write(stack.peek().idx + " ");
            }
            stack.push(new Top(i, tmp));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
class Top{
    int idx;
    int height;

    Top(int idx, int height){
        this.idx = idx;
        this.height = height;
    }
}