import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int firstValue;
    private static int twoValue;
    private static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TestCaseCount = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int i = 0; i < TestCaseCount; i++){
            st = new StringTokenizer(br.readLine());
            firstValue = Integer.parseInt(st.nextToken());
            twoValue = Integer.parseInt(st.nextToken());
            result = firstValue * twoValue / gcd(firstValue, twoValue);
            System.out.println(result);
        }
    }

    private static int gcd(int a, int b){
        if(b == 0) {
            return a;
        }else {
            return gcd(b, a % b);
        }
    }
}