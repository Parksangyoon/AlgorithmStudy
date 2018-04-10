import java.util.Scanner;

public class SW_EA_4013 {

    public static void solution() throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T, k, target, direction, turn, right, left, answer;
        int wheels[][], point[];
        T=sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            k = sc.nextInt();
            wheels = new int[4][8];
            point = new int[4];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 8; j++) {
                    wheels[i][j] = sc.nextInt();
                }
            }

            for (int j = 0; j < k; j++) {
                target = sc.nextInt() - 1;
                direction = sc.nextInt();

                right = 0;
                left = 0;
                for (int i = target; i < 3; i++) {
                    if (wheels[i][(point[i] + 2)%8] != wheels[i+1][(point[i+1] + 6)%8]) right++;
                    else break;
                }

                for (int i = target; i > 0; i--) {
                    if (wheels[i][(point[i] + 6)%8] != wheels[i-1][(point[i-1] + 2)%8]) left++;
                    else break;
                }

                point[target] = (point[target] - direction)%8;
                if (point[target] < 0) point[target] += 8;

                turn = direction;
                for (int i = 1; i <= right; i++) {
                    point[target + i] = (point[target + i] + turn)%8;
                    if (point[target + i] < 0) point[target + i] += 8;
                    turn *= -1;
                }

                turn = direction;
                for (int i = 1; i <= left; i++) {
                    point[target - i] = (point[target - i] + turn)%8;
                    if (point[target - i] < 0) point[target - i] += 8;
                    turn *= -1;
                }

            }
            answer = wheels[0][point[0]] + wheels[1][point[1]]*2 + wheels[2][point[2]]*4 + wheels[3][point[3]]*8;
            System.out.println(String.format("#%d %d", test_case, answer));

        }
    }
}

// https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeV9sKkcoDFAVH
