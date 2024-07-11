import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();

        List<String> arr = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            arr.add(str.substring(i, str.length()));
        }

        Collections.sort(arr);

        StringBuilder sb = new StringBuilder();
        for (String tmp : arr) {
            sb.append(tmp).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
