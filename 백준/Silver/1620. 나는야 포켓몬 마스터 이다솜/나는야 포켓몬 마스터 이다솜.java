import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 포켓몬의 개수
        int M = Integer.parseInt(st.nextToken()); // 질문의 개수
        HashMap<String, Integer> rankMap = new HashMap<>();
        HashMap<Integer, String> nameMap = new HashMap<>();

        for (int count = 1; count <= N; count++) {
            String temp = br.readLine();
            rankMap.put(temp, count);
            nameMap.put(count, temp);
        }

        StringBuilder result = new StringBuilder();
        for (int count = 0; count < M; count++) {

            String temp = br.readLine();

            if (temp.charAt(0) >= 49 && temp.charAt(0) <= 57) {
                result.append(nameMap.get(Integer.parseInt(temp)));
                result.append("\n");
                continue;
            }

            result.append(rankMap.get(temp));
            result.append("\n");
        }

        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }

}