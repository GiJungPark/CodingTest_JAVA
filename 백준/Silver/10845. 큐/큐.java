/*
push X: 정수 X를 큐에 넣는 연산이다.
pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 큐에 들어있는 정수의 개수를 출력한다.
empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static Queue<Integer> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        queue = new LinkedList<>();
        int last = 0;
        for(int i = 0; i < N; i++){
            String step = br.readLine();
            if(step.contains(" ")){
                String[] arr = step.split(" ");
                queue.offer(Integer.parseInt(arr[1]));
                last = Integer.parseInt(arr[1]);
            }else{
                switch (step){
                    case "pop":
                        if(!queue.isEmpty()){
                            System.out.println(queue.poll());
                        }else{
                            System.out.println("-1");
                        }
                        break;
                    case "size":
                        System.out.println(queue.size());
                        break;
                    case "empty":
                        if(!queue.isEmpty()){
                            System.out.println(0);
                        }else{
                            System.out.println(1);
                        }
                        break;
                    case "front":
                        if(!queue.isEmpty()){
                            System.out.println(queue.peek());
                        }else{
                            System.out.println("-1");
                        }
                        break;
                    case "back":
                        if(!queue.isEmpty()){
                            System.out.println(last);
                        }else{
                            System.out.println("-1");
                        }
                        break;
                }
            }
        }
    }
}