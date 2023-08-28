import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] Sender = {0, 0, 1, 1, 2, 2};
    static int[] Receiver = {1, 2, 0, 2, 0, 1};
    static boolean[][] visited;
    static boolean[] answer;
    static int[] now;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        now = new int[3];
        for(int i = 0; i < 3; i++)
            now[i] = sc.nextInt();

        visited = new boolean[201][201];
        answer = new boolean[201];

        bfs();
        for(int i = 0; i < 201; i++){
            if(answer[i]) System.out.print(i + " ");
        }
    }

    public static void bfs(){
        Queue<AB> queue = new LinkedList<>();
        queue.offer(new AB(0, 0));
        visited[0][0] = true;
        answer[now[2]] = true;
        while(!queue.isEmpty()){
            AB p = queue.poll();
            int A = p.A;
            int B = p.B;
            //C는 전체 물의 양에서 A와 B를 뺀 것
            int C = now[2] - A - B;
            //A -> B /A -> C /B -> A /B -> C /C -> A /C -> B
            for(int k = 0; k < 6; k++){
                int[] next = {A, B, C};
                next[Receiver[k]] += next[Sender[k]];
                next[Sender[k]] = 0;
                //물이 넘칠 때
                if(next[Receiver[k]] > now[Receiver[k]]){
                    //초과하는 만큼 다시 이전 물통에 넣어 줌
                    next[Sender[k]] = next[Receiver[k]] - now[Receiver[k]];
                    next[Receiver[k]] = now[Receiver[k]];
                }
                //A와 B의 물의 양을 이용해 방문 배열 체크
                if(!visited[next[0]][next[1]]){
                    visited[next[0]][next[1]] = true;
                    queue.add(new AB(next[0], next[1]));
                    //A의 물의 양이 0일 때 C의 물의 무게를 정답 변수에 저장
                    if(next[0] == 0) answer[next[2]] = true;
                }
            }
        }
    }

    //A와 B의 값만 알고 있으면 C 값은 유추할 수 있음
    static class AB{
        int A;
        int B;
        public AB(int A, int B){
            this.A = A;
            this.B = B;
        }
    }
}