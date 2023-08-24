import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] A;
    static int N, M;
    static int[] check;
    static boolean IsEven;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            String[] s = br.readLine().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            A = new ArrayList[V + 1];
            visited = new boolean[V + 1];
            check = new int[V + 1];
            IsEven = true;
            for(int t = 1; t <= V; t++){
                A[t] = new ArrayList<>();
            }
            for(int t = 0; t < E; t++){
                s = br.readLine().split(" ");
                int start = Integer.parseInt(s[0]);
                int end = Integer.parseInt(s[1]);
                A[start].add(end);
                A[end].add(start);
            }
            for(int t = 1; t <= V; t++){
                if(IsEven)
                    dfs(t);
                else break;
            }
            if(IsEven)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }

    private static void dfs(int index) {
        visited[index] = true;
            for(int i : A[index]){
                if(!visited[i]){
                    check[i] = (check[index]+1) % 2;
                    dfs(i);
                }else if(check[index] == check[i]){
                    IsEven = false;
            }
        }
    }
}