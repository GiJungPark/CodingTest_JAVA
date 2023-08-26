import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //좌표의 개수
        ArrayList<Pair> list = new ArrayList<>();
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            list.add(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(list);

        int sum = list.get(0).y - list.get(0).x;
        int end = list.get(0).y;
        for(int i = 1; i < N; i++){
            Pair step = list.get(i);
            if(end < step.x){
                sum += step.y - step.x;
                end = step.y;
            }else if(end < step.y){
                sum += step.y - end;
                end = step.y;
            }
        }

        System.out.println(sum);
    }
    static class Pair implements Comparable<Pair>{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair o) {
            if(this.x == o.x){
                return Integer.compare(this.y, o.y);
            }
            return Integer.compare(this.x, o.x);
        }
    }
}