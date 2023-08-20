import java.util.*;

public class Main {
    static ArrayList<Node>[] A;
    static long lcm;
    static boolean[] visited;
    static long[] D;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        A = new ArrayList[N];
        visited = new boolean[N];
        D = new long[N];
        lcm = 1;

        for(int i = 0; i < N; i++)
            A[i] = new ArrayList<Node>();

        for(int i = 0; i < N - 1; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int p = sc.nextInt();
            int q = sc.nextInt();
            A[a].add(new Node(b, p, q));
            A[b].add(new Node(a, q, p));
            lcm *= (p * q / gcd(p, q));
        }

        D[0] = lcm;
        dfs(0);
        long mgcd = D[0];
        for(int i = 1; i < N; i++)
            mgcd = gcd(mgcd, D[i]);

        for(int i = 0; i < N; i++)
            System.out.print(D[i] / mgcd + " ");
    }

    private static long gcd(long a, long b){
        if(b == 0) {
            return a;
        }else {
            return gcd(b, a % b);
        }
    }

    private static void dfs(int node){
        visited[node] = true;
        for(Node i : A[node]){
            int next = i.getB();
            if(!visited[next]){
                D[next] = D[node] * i.getQ() / i.getP();
                dfs(next);
            }
        }
    }

    static class Node{
        int b;
        int p;
        int q;
        private Node(int b, int p, int q){
            super();
            this.b = b;
            this.p = p;
            this.q = q;
        }
        private int getB(){
            return this.b;
        }

        private int getP(){
            return this.p;
        }

        private int getQ(){
            return this.q;
        }
    }
}