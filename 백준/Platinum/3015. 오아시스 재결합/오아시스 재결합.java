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

        bw.write(countPeople(N) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static long countPeople(int N) {
        Stack<Pair> stack = new Stack<>();
        long count = 0;
        for(int i = 0; i < N; i++){
            Pair next = new Pair(i, 1);
            while(!stack.isEmpty() && arr[stack.peek().idx] <= arr[i]){
                Pair pop = stack.pop();
                count += pop.cnt;
                if(arr[pop.idx] == arr[i]) next.cnt += pop.cnt;
            }

            if(!stack.isEmpty()){
                count ++;
            }

            stack.push(next);
        }

        return count;
    }
}

class Pair {
    int idx, cnt;
    Pair(int idx, int cnt){
        this.idx = idx;
        this.cnt = cnt;
    }
}
