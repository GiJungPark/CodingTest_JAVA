import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine()); //테스트케이스 수를 나타내는 자연수 T

        for(int i = 0; i < T; i++){
            int N = Integer.parseInt(br.readLine()); //날의 수를 나타내는 자연수 N(2 ≤ N ≤ 1,000,000)
            st = new StringTokenizer(br.readLine());

            //주식 흐름 배열
            int[] arr = new int[N];
            for(int k = 0; k < N; k++){
                 arr[k] = Integer.parseInt(st.nextToken());
            }

            //역방향으로 탐색을 진행
            //가장 마지막 값을 최대 값으로 두고
            //뒤에서 부터 최대 값 보다 작거나 같으면 sum에 격차 값 저장
            //최대 값 보다 큰 값이 나온다면 최대 값 변경
            int max = arr[N - 1];
            long sum = 0;
            for(int k = N - 2; k >= 0; k--){
                int step = arr[k];
                if(max < step) {
                    max = step;
                }else{
                    sum += max - step;
                }
            }
            bw.write(sum + "\n");
            bw.flush();
        }
        bw.close();
        br.close();
    }
}