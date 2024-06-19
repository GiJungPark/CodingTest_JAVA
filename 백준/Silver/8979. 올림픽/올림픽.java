import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Rank[] Arr = new Rank[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());

            Arr[i] = new Rank(num, gold, silver, bronze);
        }

        Arrays.sort(Arr);


        for (int i = 0; i < N; i++) {
            if (Arr[i].num == M) {
                int num = i;
                while (checkBefore(Arr, num)) {
                    num--;
                }

                System.out.println(num + 1);
            }
        }
    }

    static public boolean checkBefore(Rank[] Arr, int num) {
        if (Arr[num - 1].gold != Arr[num].gold) {
            return false;
        }

        if (Arr[num - 1].silver != Arr[num].silver) {
            return false;
        }

        if (Arr[num - 1].bronze != Arr[num].bronze) {
            return false;
        }

        return true;
    }

    static class Rank implements Comparable<Rank>{
        int num;
        int gold;
        int silver;
        int bronze;

        Rank(int num, int gold, int silver, int bronze) {
            this.num = num;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        @Override
        public int compareTo(Rank o) {
            if (this.gold == o.gold) {
                if (this.silver == o.silver) {
                    return this.bronze - o.bronze;
                }
                return this.silver - o.silver;
            }
            return this.gold - o.gold;
        }
    }
}