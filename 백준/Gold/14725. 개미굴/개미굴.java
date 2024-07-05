import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Main {

    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = parseInt(br.readLine());
        Node root = new Node();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int depth = parseInt(st.nextToken());
            Node current = root;

            for (int k = 0; k < depth; k++) {
                String temp = st.nextToken();

                if (!current.childs.containsKey(temp)) {
                    current.childs.put(temp, new Node());
                }

                current = current.childs.get(temp);
            }
        }

        print(root, "");
        bw.flush();
        bw.close();

    }

    public static void print(Node root, String bar) throws IOException {
        Object[] keys = root.childs.keySet().toArray();

        Arrays.sort(keys);

        for (Object temp : keys) {
            bw.write(new StringBuilder(bar).append(temp).append("\n").toString());
            print(root.childs.get(temp), new StringBuilder(bar).append("--").toString());
        }
    }

    static class Node {
        HashMap<String, Node> childs = new HashMap<>();
    }
}
