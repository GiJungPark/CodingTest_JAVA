import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] arr = new int[26];

        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            if ('A' <= temp && temp <= 'Z') {
                arr[temp - 'A']++;
            }
            else if ('a' <= temp && temp <= 'z') {
                arr[temp - 'a']++;
            }
        }

        int max = 0;
        char result = '?';
        boolean isDuplicate = false;

        for (int i = 0; i < 26; i++) {
            if (arr[i] > max) {
                max = arr[i];
                result = (char)('A' + i);
                isDuplicate = false;
            } else if (arr[i] == max) {
                isDuplicate = true;
            }
        }

        if (isDuplicate) {
            System.out.println('?');
        } else {
            System.out.println(result);
        }
    }
}