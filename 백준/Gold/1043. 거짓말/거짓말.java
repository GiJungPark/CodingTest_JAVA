import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 유니온 파인드
public class Main {
    static int[] parent;
    static int[] trueP;
    static ArrayList<Integer>[] party;
    static int result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 사람의 수
        int M = Integer.parseInt(st.nextToken()); // 파티의 수

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        result = 0;
        trueP = new int[T];
        for(int i = 0; i < T; i++){
            trueP[i] = Integer.parseInt(st.nextToken());
        }

        party = new ArrayList[M];
        for(int i = 0; i < M; i++){
            party[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int party_size = Integer.parseInt(st.nextToken());
            for(int j = 0; j < party_size; j++){
                party[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        // 처음 각 노드의 대표는 자기 자신이다.
        parent = new int[N + 1];
        for(int i = 1; i <= N; i++){
            parent[i] = i;
        }

        for(int i = 0; i < M; i++){
            int firstPeople = party[i].get(0);
            for(int j = 1; j < party[i].size(); j++){
                union(firstPeople, party[i].get(j));
            }
        }

        // 각 파티의 대표노드와 진실을 아는 사람들의 대표 노드가 같다면 과장할 수 없음
        for(int i = 0; i < M; i++){
            boolean isPossible = true;
            int cur = party[i].get(0);
            for(int j = 0; j < trueP.length; j++){
                if(find(cur) == find(trueP[j])){
                    isPossible = false;
                    break;
                }
            }
            if(isPossible) result++;
        }

        bw.write(result + "\n");
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
}