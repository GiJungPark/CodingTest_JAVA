//push X: 정수 X를 스택에 넣는 연산이다.
//pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//size: 스택에 들어있는 정수의 개수를 출력한다.
//empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
//top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            switch (str){
                case "pop":
                    if(stack.isEmpty()){
                        bw.write(-1 + "\n");
                    }else{
                        bw.write(stack.pop() + "\n");
                    }
                    break;
                case "size":
                    bw.write(stack.size() + "\n");
                    break;
                case "empty":
                    if(stack.isEmpty()){
                        bw.write(1 + "\n");
                    }else{
                        bw.write(0 + "\n");
                    }
                    break;
                case "top":
                    if(stack.isEmpty()){
                        bw.write(-1 + "\n");
                    }else{
                        bw.write(stack.peek() + "\n");
                    }
                    break;
                default:
                    String[] step = str.split(" ");
                    stack.push(Integer.parseInt(step[1]));
                    break;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}