package SW_EA;

import java.util.Scanner;

public class SW_EA_4012 {

    public void solutiuon() throws Exception {

        Scanner sc = new Scanner(System.in);
        int T, N;
        int[][] S;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            S = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (S[j][i] != 0) S[j][i] += sc.nextInt();
                    else S[i][j] = sc.nextInt();
                }
            }
            InitData(N, S);
            selectFood(0, 1);

            System.out.println(String.format("#%d %d", test_case, getPoint()));
        }
    }

    int[] check;
    int n;
    int[][] s;
    int point;

    void InitData(int N, int[][] S) {
        n = N;
        s = S;
        point = Integer.MAX_VALUE;
        check = new int[n];
    }
    void selectFood(int from, int step) {
        if (step == 1) {
            for (int i = 0; i < n/2; i++) {
                check[i] = 1;
                selectFood(i+1, step+1);
                check[i] = 0;
            }
        }
        else if (step == n/2) {
            for (int i = from; i < n; i++) {
                check[i] = 1;
                point = Math.min(calcPoint(), point);
                check[i] = 0;
            }
        }
        else {
            for (int i = from; i < n; i++) {
                check[i] = 1;
                selectFood(i+1, step+1);
                check[i] = 0;
            }
        }
    }

    int calcPoint() {
        int[][] selected = new int[2][n/2];
        int[] index = new int[2], score = new int[2];

        for (int i = 0; i < n; i++) {
            if (check[i] == 1) {
                selected[0][index[0]++] = i;
            }
            else {
                selected[1][index[1]++] = i;
            }
        }
        for (int i = 0; i < n/2 - 1; i++) {
            for (int j = i+1; j < n/2; j++) {
                score[0] += s[selected[0][i]][selected[0][j]];
                score[1] += s[selected[1][i]][selected[1][j]];
            }
        }
        return Math.abs(score[0] - score[1]);
    }

    int getPoint() {
        return point;
    }
}

// https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeUtVakTMDFAVH
