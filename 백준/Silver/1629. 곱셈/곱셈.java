import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Long.parseLong;

public class Main {

    private static long C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = parseLong(st.nextToken());
        long B = parseLong(st.nextToken());
        C = parseLong(st.nextToken());

        System.out.println(pow(A, B));

    }

    public static long pow(long A, long exponent) {
        if (exponent == 1) {
            return A % C;
        }

        long temp = pow(A, exponent / 2);

        if (exponent % 2 == 1) {
            return (temp * temp % C) * A % C;
        }
        else {
            return temp * temp % C;
        }

    }
}
