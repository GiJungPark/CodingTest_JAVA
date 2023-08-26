import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //멀티탭 구멍의 개수 (1 ≤ N ≤ 100)
        int M = Integer.parseInt(st.nextToken()); //전기 용품의 총 사용횟수 (1 ≤ K ≤ 100)

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[M];
        for(int i = 0; i < M; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        //"전기용품의 이름이 K 이하의 자연수"
        boolean[] used = new boolean[101];
        int size = 0;
        int result = 0;

        for(int i = 0; i < M; i++) {
            if (!used[arr[i]]) {
                if (size < N) {
                    used[arr[i]] = true;
                    size++;
                } else {
                    ArrayList<Integer> list = new ArrayList<>();
                    //사용중인 콘센트 중에 앞으로 계속 사용되는 콘센트가 있는지 확인
                    //있다면 리스트에 저장한다.
                    for (int k = i; k < M; k++) {
                        int step = arr[k];
                        if (used[step] && !list.contains(step)) {
                            list.add(step);
                        }
                    }

                    //앞으로 사용하지 않는 콘센트가 존재하는 경우
                    //해당 콘센트를 찾아서 제거한다.
                    if (list.size() < N) {
                        for (int k = 1; k <= 100; k++) {
                            if (used[k] && !list.contains(k)) {
                                used[k] = false;
                                break;
                            }
                        }
                    }

                    //현재 사용중인 콘센트 전부가 사용 예정인 경우
                    //가장 나중에 사용할 콘센트를 제거한다.
                    else {
                        int lastIdx = list.get(list.size() - 1);
                        used[lastIdx] = false;
                    }

                    used[arr[i]] = true;
                    result++;
                }
            }
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}