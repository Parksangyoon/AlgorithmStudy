package SW_EA;

import java.util.ArrayList;
import java.util.Scanner;

public class SW_EA_2117 {

    public static void solution() throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T, N, M;
        int[][] place;

        T=sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            M = sc.nextInt();

            place = new int[N][N];

            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++)
                    place[i][j] = sc.nextInt();

            int range = N+1;

            int count, kx, ky, profit;
            ArrayList<int[]> kRange = new ArrayList<>();
            kRange.add(new int[]{0, 0});
            int[] startPoint = new int[]{0, 0};
            int answer = 0;

            for (int i = 1; i <= range; i++) {

                int turnNum = i - 1;
                for (int a = 0; a < turnNum; a++)
                    kRange.add(new int[]{startPoint[0] - a, startPoint[1] - turnNum + a});
                for (int a = 0; a < turnNum; a++)
                    kRange.add(new int[]{startPoint[0] - turnNum + a, startPoint[1] + a});
                for (int a = 0; a < turnNum; a++)
                    kRange.add(new int[]{startPoint[0] + a, startPoint[1] + turnNum - a});
                for (int a = 0; a < turnNum; a++)
                    kRange.add(new int[]{startPoint[0] + turnNum - a, startPoint[1] - a});

                for (int y = 0; y < N; y++) {
                    for (int x = 0; x < N; x++) {
                        count = 0;
                        for (int s = 0; s < kRange.size(); s++) {
                            kx = kRange.get(s)[0] + x;
                            if (kx < 0 || kx >= N) continue;
                            ky = kRange.get(s)[1] + y;
                            if (ky < 0 || ky >= N) continue;

                            if (place[ky][kx] == 1) {
                                count = count + 1;
                            }
                        }

                        for (int a = 0; a < N; a++) {
                            for (int b = 0; b < N; b++) {
                                if (place[a][b] == 3) {
                                    place[a][b] = 1;
                                }
                                else if (place[a][b] == 2){
                                    place[a][b] = 0;
                                }
                            }
                        }

                        profit = count * M - (i*i + (i-1)*(i-1));

                        if (profit >= 0) {
                            answer = Math.max(answer, count);
                        }
                    }
                }
            }


            System.out.println(String.format("#%d %d", test_case, answer));
        }
    }

}

// https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5V61LqAf8DFAWu
