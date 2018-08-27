package Baekjoon;

import java.util.Scanner;

public class Baekjoon_2003 {

    public static void solution() throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int N, M;
        N=sc.nextInt();
        M=sc.nextInt();

        int A[] = new int[N+1];

        for (int i = 1; i <= N; i++) A[i] = sc.nextInt();

        int LIdx = 1, RIdx = 1, cnt = 0, sum = A[LIdx];

        while (LIdx <= N && RIdx <= N) {
            if (sum >= M) {
                if (sum == M) cnt++;
                if (LIdx >= N) break;
                sum -= A[LIdx++];
            }
            else if (sum < M) {
                RIdx++;
                if (RIdx > N) break;
                sum += A[RIdx];
            }

        }
        System.out.println(cnt);
    }
}


// https://www.acmicpc.net/problem/2003
