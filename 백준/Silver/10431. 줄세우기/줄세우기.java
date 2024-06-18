import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static final String RESULT = "%d %d\n";
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bf.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int mainNumber = Integer.parseInt(st.nextToken());
            List<Integer> list = new ArrayList<>();
            list.add(Integer.parseInt(st.nextToken()));
            int total = 0;

            for (int j = 1; j < 20; j++) {
                int currentNumber = Integer.parseInt(st.nextToken());
                int listSize = list.size();
                for(int k = 0; k < listSize; k++) {
                    if (list.get(k) > currentNumber) {
                        total += list.size() - k;
                        list.add(k, currentNumber);
                        break;
                    }
                }

                if (listSize == list.size()) {
                    list.add(currentNumber);
                }
            }

            bw.write(String.format(RESULT, mainNumber, total));
            bw.flush();
        }

        bw.close();
    }
}
