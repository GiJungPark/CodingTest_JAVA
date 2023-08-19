import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        long a = sc.nextLong();
        long b = sc.nextLong();
        long result = gcd(a, b);
        StringBuffer sb = new StringBuffer();
        while(result > 0){
            sb.append("1");
            result--;
        }
        System.out.println(sb.toString());
    }

    private static long gcd(long a, long b){
        if(b == 0) {
            return a;
        }else {
            return gcd(b, a % b);
        }
    }
}