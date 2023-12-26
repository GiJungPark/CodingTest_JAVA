import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static int answer = 0;
    static int deleteNode = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        tree = new ArrayList[N];
        visited = new boolean[N];
        int root = 0;

        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < N; i++) {
            int p = scanner.nextInt();
            if (p != -1) {
                tree[i].add(p);
                tree[p].add(i);
            } else {
                root = i;
            }
        }

        deleteNode = scanner.nextInt();
        if (deleteNode == root) {
            System.out.println(0);
        } else {
            DFS(root);
            System.out.println(answer);
        }
    }

    static void DFS(int number) {
        visited[number] = true;
        int cNode = 0;
        for (int i : tree[number]) {
            if (!visited[i] && i != deleteNode) {
                cNode++;
                DFS(i);
            }
        }

        if(cNode == 0) {
            answer++;
        }
    }
}