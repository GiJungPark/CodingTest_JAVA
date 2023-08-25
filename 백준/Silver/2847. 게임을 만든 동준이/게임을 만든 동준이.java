import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < N; i++){
            stack.push(sc.nextInt());
        }

        int max = stack.pop();
        int count = 0;
        while(!stack.isEmpty()){
            int value = stack.pop();
            while(max <= value){
                value--;
                count++;
            }
            max = value;
        }

        System.out.println(count);
    }
}