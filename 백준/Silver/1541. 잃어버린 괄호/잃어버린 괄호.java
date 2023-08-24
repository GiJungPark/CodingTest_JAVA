import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] subArr = br.readLine().split("-");
        int result = 0;
        boolean first = true;
        for(String subStr : subArr){
            String[] addArr = subStr.split("\\+");
            int tmp = 0;
            for(String addStr : addArr){
                tmp += Integer.parseInt(addStr);
            }
            if(first){
                result += tmp;
                first = false;
            }else{
                result -= tmp;
            }
        }
        System.out.println(result);
    }
}