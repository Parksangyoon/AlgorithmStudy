package SW_EA;

import java.util.Scanner;

public class SW_EA_4112 {
    public static void solution() throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T, N, X, Y, Y2, x, y, answer;
        T=sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            Y = (int)(1+Math.sqrt(8*N-7))/2;
            X = N - Y*(Y-1)/2;

            N = sc.nextInt();
            Y2 = (int)(1+Math.sqrt(8*N-7))/2;
            Y = Y2 - Y;
            X = N - Y2*(Y2-1)/2 - X;

            x = Math.abs(X);
            y = Math.abs(Y);

            if (x == 0 && y == 0) {
                answer = 0;
            }
            else if (X*Y < 0) {
                answer = x+y;
            }
            else if (x > y) {
                answer = x;
            }
            else {
                answer = y;
            }

            System.out.println(String.format("#%d %d", test_case, answer));

        }
    }
}

// https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWJHmLraeEwDFAUH&categoryId=AWJHmLraeEwDFAUH&categoryType=CODE&&&
