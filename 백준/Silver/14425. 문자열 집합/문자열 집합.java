import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        tNode root = new tNode();

        while (N > 0) {
            String text = scanner.next();
            tNode now = root;
            
            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);

                if (now.next[c - 'a'] == null) {
                    now.next[c - 'a'] = new tNode();
                }

                now = now.next[c - 'a'];
                if (i == text.length() - 1)
                    now.isEnd = true;
            }

            N--;
        }

        int count = 0;
        
        while (M > 0) {
            String text = scanner.next();
            tNode now = root;
            
            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);
                
                if (now.next[c - 'a'] == null) {
                    break;
                }
                
                now = now.next[c - 'a'];
                if (i == text.length() - 1 && now.isEnd)
                    count++;
            }
            M--;
        }
        System.out.println(count);
    }
}

class tNode {
    tNode[] next = new tNode[26];
    boolean isEnd;
}