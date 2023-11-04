import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int  N = Integer.parseInt(br.readLine()); // 세로

        String result;
        if(N % 2 == 1) {
            result = "SK";
        }else{
            result = "CY";
        }


        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }

}