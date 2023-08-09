
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < N; i++){
            queue.offer(Integer.parseInt(st.nextToken()));
        }
        int count = 1;

        while(!queue.isEmpty()) {
            if (queue.peek() == count) {
                queue.poll();
                count++;
            }else if(!stack.isEmpty() && stack.peek() == count){
                stack.pop();
                count++;
            }else{
                stack.push(queue.poll());
            }
        }

        while (!stack.isEmpty()) {
            if (count == stack.peek()) {
                count++;
                stack.pop();
            } else {
                System.out.println("Sad");
                return;
            }
        }
        
        System.out.println("Nice");
    }
}