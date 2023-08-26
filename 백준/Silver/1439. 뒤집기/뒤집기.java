import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int last = -1;
        int[] arr = new int[2];

        for(int i = 0; i < str.length(); i++){
            int step = str.charAt(i) - '0';
            if(last != step){
                arr[step]++;
                last = step;
            }
        }

        int result = Math.min(arr[0], arr[1]);
        System.out.println(result);
    }
}