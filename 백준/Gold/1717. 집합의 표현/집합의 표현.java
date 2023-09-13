import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 유니온 파인드
public class Main {
    static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 처음 각 노드의 대표는 자기 자신이다.
        parent = new int[N + 1];
        for(int i = 0; i <= N; i++){
            parent[i] = i;
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int question = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(question == 0){ // "합집합은 '0 a b'의 형태로 입력이 주어진다."
                union(a, b);
            } else { // "두 원소가 같은 집합에 포함되어 있는지를 확인하는 연산 '1 a b'의 형태로 입력이 주어진다."
                if(checkSame(a, b)){
                    bw.write("YES \n");
                }else{
                    bw.write("NO \n");
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void union(int a, int b) { // union 연산: 대표 노드끼리 연결하기
        a = find(a);
        b = find(b);
        if(a != b) {
            parent[b] = a;
        }
    }

    public static int find(int a) { // find 연산
        if(a == parent[a]) {
            return a;
        } else {
            return parent[a] = find(parent[a]); // 재귀 함수의 형태로 find 연산 구현
        }
    }

    public static boolean checkSame(int a, int b) { // 두 원소가 같은 집합인지 확인하기
        a = find(a);
        b = find(b);

        if(a == b) {
            return true;
        } else {
            return false;
        }
    }
}