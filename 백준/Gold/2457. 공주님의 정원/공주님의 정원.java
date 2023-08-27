import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        ArrayList<Pair> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) * 100 + Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken()) * 100 + Integer.parseInt(st.nextToken());
            list.add(new Pair(start, end));
        }

        Collections.sort(list);

//        for (Pair tmp : list)
//            System.out.println(tmp.start + " " + tmp.end);

        int result = 0;
        int idx = 0;
        int start = 301;
        int max = 0;

        while (start < 1201) {
            boolean flag = false;
            for (int i = idx; i < N; i++) {
                Pair pair = list.get(i);
                if (pair.start > start) break;
                if (pair.start <= start && pair.end > max) {
                    flag = true;
                    max = pair.end;
                    idx = i + 1;
                }
            }

            if (flag) {
                start = max;
                result++;
            } else {
                break;
            }
        }

        if(max < 1201) {
            bw.write(0 + "\n");
        } else {
            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
    static class Pair implements Comparable<Pair>{
        int start, end;
        Pair(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Pair o) {
            if(this.start == o.start) return o.end - this.end;
            return this.start - o.start;
        }
    }
}