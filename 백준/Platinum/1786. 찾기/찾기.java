import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String parent = br.readLine();
        String pattern = br.readLine();

        KMP(parent, pattern);

        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");
        for (int num : result) {
            sb.append(num).append(" ");
        }

        System.out.println(sb);
    }

    static int[] makeTable(String pattern) {
        int patternSize = pattern.length();
        int[] table = new int[patternSize];
        int j = 0;

        for (int i = 1; i < patternSize; i++) {
            while (j > 0 && pattern.charAt(j) != pattern.charAt(i)) {
                j = table[j - 1];
            }

            if (pattern.charAt(j) == pattern.charAt(i)) {
                table[i] = ++j;
            }
        }

        return table;
    }

    static void KMP(String parent, String pattern) {
        int[] table = makeTable(pattern);
        int parentSize = parent.length();
        int patternSize = pattern.length();

        int j = 0;
        for (int i = 0; i < parentSize; i++) {
            if (j > 0 && parent.charAt(i) != pattern.charAt(j)) {
                j = table[j - 1];
            }

            if (parent.charAt(i) == pattern.charAt(j)) {
                if (j == patternSize - 1) {
                    result.add(i - patternSize + 2);
                    j = table[j];
                }
                else {
                    j++;
                }
            }
        }
    }
}