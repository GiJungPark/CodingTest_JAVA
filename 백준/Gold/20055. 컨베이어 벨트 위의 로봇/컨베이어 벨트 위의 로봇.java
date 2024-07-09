// 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
// 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 만약 이동할 수 없다면 가만히 있는다.
// 로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있어야 한다.
// 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
// 내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다. 그렇지 않다면 1번으로 돌아간다.
// 몇 번째 단계가 진행 중일때 종료되었는지 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = parseInt(st.nextToken());
        int K = parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        List<Conveyor> conveyorBelt = new LinkedList<>();
        for (int i = 0; i < 2 * N; i++) {
            int negodo = parseInt(st.nextToken());
            conveyorBelt.add(new Conveyor(negodo));
        }

        int expiredCount = 0;
        int count = 0;
        while (expiredCount < K) {
            count++;

            conveyorBelt.add(0, conveyorBelt.remove(2 * N -1));
            conveyorBelt.get(N - 1).removeRobot();

            for (int i = N - 2; i >= 0; i--) {
                Conveyor next = conveyorBelt.get(i + 1);
                conveyorBelt.get(i).moveRobot(next);
            }
            conveyorBelt.get(N - 1).removeRobot();


            conveyorBelt.get(0).addRobot();


            expiredCount = (int) conveyorBelt.stream()
                    .filter(Conveyor::isExpired)
                    .count();

        }

        System.out.println(count);
    }

    static class Conveyor {
        int negodo;
        boolean isThereRobot;

        Conveyor(int negodo) {
            this.negodo = negodo;
            this.isThereRobot = false;
        }

        public void addRobot() {
            if (this.negodo > 0) {
                this.isThereRobot = true;
                this.negodo -= 1;
            }
        }

        public void removeRobot() {
            if (this.isThereRobot) {
                this.isThereRobot = false;
            }
        }

        public void moveRobot(Conveyor nextConveyor) {
            if (this.isThereRobot && !nextConveyor.isThereRobot && nextConveyor.negodo >= 1) {
                this.isThereRobot = false;
                nextConveyor.isThereRobot = true;
                nextConveyor.negodo -= 1;
            }
        }

        public boolean isExpired() {
            return this.negodo == 0;
        }
    }
}
