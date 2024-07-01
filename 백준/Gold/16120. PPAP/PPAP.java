import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    private static final Character P = 'P';
    private static final String NP = "NP";
    private static final String PPAP = "PPAP";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            Character temp = str.charAt(i);
            if (temp == P) {
                stack.push(temp);
            } else {
                if (stack.size() >= 2 && i <= str.length() - 2 && str.charAt(i + 1) == P) {
                    stack.pop();
                    stack.pop();
                } else {
                    System.out.println(NP);
                    return;
                }
            }
        }

        if (stack.size() == 1) {
            System.out.println(PPAP);
        } else {
            System.out.println(NP);
        }
    }
}