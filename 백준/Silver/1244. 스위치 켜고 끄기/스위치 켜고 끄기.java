import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int switchNum = parseInt(br.readLine());
        int switchOnNum = 0;
        int[] switchArr = new int[switchNum + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= switchNum; i++) {
            switchArr[i] = parseInt(st.nextToken());
            if (switchArr[i] == 1) {
                switchOnNum++;
            }
        }

        int studentNum = parseInt(br.readLine());
        for (int i = 0; i < studentNum; i++) {
            st = new StringTokenizer(br.readLine());
            int studentSex = parseInt(st.nextToken());
            int num = parseInt(st.nextToken());

            // 남학생인 경우
            if (studentSex == 1) {
                for (int j = num; j < switchArr.length; j += num) {
                    swap(switchArr, j);
                }
            }

            // 여학생인 경우
            if (studentSex == 2) {
                int start = num;
                int end = num;
                while (start - 1 > 0 && end + 1 < switchArr.length) {
                    if (switchArr[start - 1] != switchArr[end + 1]) {
                        break;
                    }
                    start--;
                    end++;
                }

                for (int j = start; j <= end; j++) {
                    swap(switchArr, j);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < switchArr.length; i++) {
            sb.append(switchArr[i] + " ");
            if (i % 20 == 0) {
                sb.append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void swap(int[] Arr, int num) {
        if (Arr[num] == 0) {
            Arr[num] = 1;
        } else {
            Arr[num] = 0;
        }
    }
}