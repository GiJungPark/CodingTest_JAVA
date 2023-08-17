import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        //회의 시작, 끝 배열 생성
        int[][] A = new int[N][2];
        for(int i = 0; i < N; i++){
            A[i][0] = sc.nextInt();
            A[i][1] = sc.nextInt();
        }

        //종료 시간대로 정렬하되, 종료 시간이 같을 경우는 시작 시간으로 정렬
        Arrays.sort(A, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        //겹치지 않는 회의 회수 카운팅
        int count = 0;
        int end = 0;
        for(int i = 0; i < N; i++){
            if(A[i][0] >= end){
                end = A[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}