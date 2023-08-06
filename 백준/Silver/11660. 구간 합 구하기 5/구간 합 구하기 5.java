import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int quizNo = Integer.parseInt(st.nextToken());

        //입력되는 원본 배열 만들기
        int[][] arr = new int[size + 1][size + 1];
        for(int j = 1; j <= size; j++){
            st = new StringTokenizer(br.readLine());
            for(int k = 1; k <= size; k++){
                arr[j][k] = Integer.parseInt(st.nextToken());
            }
        }

        //구간 합 배열 만들기
        //구간 합[j][k] = 배열[j][k-1] + 배열[j-1][k] - 배열[j-1][k-1] + 배열[j][k]
        int[][] sumArr = new int[size + 1][size + 1];
        for(int j = 1; j <= size; j++){
            for(int k = 1; k <= size; k++){
                sumArr[j][k] = sumArr[j][k-1] + sumArr[j-1][k] - sumArr[j-1][k-1] + arr[j][k];
            }
        }

        //구간 합의 결과 출력
        //(x1, y1), (x2, y2)의 구간 합 = 구간 합[j][k-1] + 구간 합[j-1][k] - 구간 합[j-1][k-1]
        for(int i = 0; i < quizNo; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int result = sumArr[x2][y2] - sumArr[x2][y1-1] - sumArr[x1-1][y2] + sumArr[x1-1][y1-1];
            System.out.println(result);
        }
    }
}