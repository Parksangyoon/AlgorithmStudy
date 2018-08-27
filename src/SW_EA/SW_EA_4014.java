package SW_EA;

import java.util.Scanner;

public class SW_EA_4014 {

    public static void solution() throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T, N, X, answer, currentLength, checkCount;
        boolean check, downType;
        int place[][];
        T=sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N=sc.nextInt();
            X=sc.nextInt();

            place = new int[N][N];
            answer = 0;

            for (int i = 0; i < N; i++) {
                currentLength = -1;
                checkCount = 0;
                check = true;
                downType = false;

                for (int j = 0; j < N; j++) {
                    place[j][i] = sc.nextInt();

                    if (!check) continue;

                    if (!downType) {
                        if (currentLength == -1) {
                            currentLength = place[j][i];
                            checkCount = 1;
                        }
                        else if (currentLength == place[j][i]) checkCount++;
                        else if (currentLength + 1 == place[j][i]) {
                            currentLength = place[j][i];
                            if (checkCount < X) check = false;
                            checkCount = 1;
                        }
                        else if (currentLength - 1 == place[j][i]) {
                            currentLength = place[j][i];
                            if (X == 1) checkCount = 0;
                            else {
                                if (N-j < X) check = false;
                                else {
                                    checkCount = 1;
                                    downType = true;
                                }
                            }

                        } else check = false;
                    } else {
                        if (currentLength == place[j][i]) {
                            checkCount++;
                            if (X <= checkCount) {
                                downType = false;
                                checkCount = 0;
                            }
                        }
                        else check = false;
                    }

                }
                if (check) answer++;
            }

            for (int j = 0; j < N; j++) {
                currentLength = -1;
                checkCount = 0;
                check = true;
                downType = false;

                for (int i = 0; i < N; i++) {
                    if (!downType) {
                        if (currentLength == -1) {
                            currentLength = place[j][i];
                            checkCount = 1;
                        }
                        else if (currentLength == place[j][i]) checkCount++;
                        else if (currentLength + 1 == place[j][i]) {
                            currentLength = place[j][i];
                            if (checkCount < X){
                                check = false;
                                break;
                            }
                            checkCount = 1;
                        }
                        else if (currentLength - 1 == place[j][i]) {
                            currentLength = place[j][i];
                            if (X == 1) checkCount = 0;
                            else {
                                if (N-i < X) check = false;
                                else {
                                    checkCount = 1;
                                    downType = true;
                                }
                            }
                        } else {
                            check = false;
                            break;
                        }
                    } else {
                        if (currentLength == place[j][i]) {
                            checkCount++;
                            if (X <= checkCount) {
                                downType = false;
                                checkCount = 0;
                            }
                        }
                        else{
                            check = false;
                            break;
                        }
                    }

                }
                if (check) answer++;
            }

            System.out.println(String.format("#%d %d", test_case, answer));

        }
    }
}

// https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeW7FakkUDFAVH
