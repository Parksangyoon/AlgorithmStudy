import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SW_EA_2477 {

    final static int NUM = 0;
    final static int TIME = 1;
    final static int END_TIME = 2;
    final static int N_NUM = 2;

    public static void solution() throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T, N, M, K, A, B, answer;
        int[][] KData;
        int[][] NData, MData;
        ArrayList<Integer> check;

        T=sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            M = sc.nextInt();
            K= sc.nextInt();
            A= sc.nextInt();
            B= sc.nextInt();

            check = new ArrayList<>();

            NData = new int[N][3];
            MData = new int[M][3];
            KData = new int[K][3];

            for (int i = 0; i < N; i++) {
                NData[i][NUM] = i+1;
                NData[i][TIME] = sc.nextInt();
            }
            for (int i = 0; i < M; i++) {
                MData[i][NUM] = i+1;
                MData[i][TIME] = sc.nextInt();
            }
            for (int i = 0; i < K; i++) {
                KData[i][NUM] = i+1;
                KData[i][TIME] = sc.nextInt();
            }

            int minTimeIndex = 0;

            for (int i = 0; i < K; i++) {
                for (int j = 0; j < N; j++) {
                    if (KData[i][TIME] >= NData[j][END_TIME]) {
                        KData[i][TIME] = NData[j][END_TIME] = KData[i][TIME] + NData[j][TIME];
                        KData[i][N_NUM] = NData[j][NUM];
                        if (NData[j][NUM] == A) check.add(KData[i][NUM]);
                        break;
                    }
                    if (j == N - 1) {
                        minTimeIndex = 0;

                        for (int m = 0; m < N; m++) {
                            minTimeIndex = min(NData[minTimeIndex][END_TIME], NData[m][END_TIME], minTimeIndex, m);
                        }

                        KData[i][TIME] = NData[minTimeIndex][END_TIME] = NData[minTimeIndex][END_TIME] + NData[minTimeIndex][TIME];
                        KData[i][N_NUM] = NData[minTimeIndex][NUM];
                        if (NData[minTimeIndex][NUM] == A) check.add(KData[i][NUM]);
                    }
                }

            }

            sortTypeTwo(KData);
            sortTypeOne(KData);

            answer = 0;
            for (int i = 0; i < K; i++) {
                for (int j = 0; j < M; j++) {
                    if (KData[i][TIME] >= MData[j][END_TIME]) {
                        KData[i][TIME] = MData[j][END_TIME] = KData[i][TIME] + MData[j][TIME];
                        if (MData[j][NUM] == B && check.contains(KData[i][NUM])) {
                            answer += KData[i][NUM];
                        }
                        break;
                    }
                    if (j == M - 1) {
                        minTimeIndex = 0;
                        for (int m = 0; m < M; m++) {
                            minTimeIndex = min(MData[minTimeIndex][END_TIME], MData[m][END_TIME], minTimeIndex, m);
                        }
                        KData[i][TIME] = MData[minTimeIndex][END_TIME] = MData[minTimeIndex][END_TIME] + MData[minTimeIndex][TIME];
                        if (MData[minTimeIndex][NUM] == B && check.contains(KData[i][NUM])) {
                            answer += KData[i][NUM];
                        }
                    }
                }
            }

            System.out.println(String.format("#%d %d", test_case, (answer == 0) ? -1 : answer));
        }
    }

    static int min(int a, int b, int aIndex, int bIndex) {
        if (a < b) return aIndex;
        else if (a > b) return bIndex;
        else return (aIndex < bIndex) ? aIndex : bIndex;
    }

    static void sortTypeOne(int[][] data) {
        Arrays.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(final int[] o1,final int[] o2) {
                final int temp1 = o1[1];
                final int temp2 = o2[1];
                return Integer.compare(temp1, temp2);
            }
        });
    }

    static void sortTypeTwo(int[][] data) {
        Arrays.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(final int[] o1,final int[] o2) {
                final int temp1 = o1[2];
                final int temp2 = o2[2];
                return Integer.compare(temp1, temp2);
            }
        });
    }

}

// https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV6c6bgaIuoDFAXy
