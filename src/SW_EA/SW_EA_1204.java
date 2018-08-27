package SW_EA;

import java.util.Arrays;
import java.util.Scanner;

public class SW_EA_1204 {
    public static void solution(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int countOfScores[] = new int[101];
        int maxOfValue, maxOfCount;

        for (int test_case = 1; test_case <= 10; test_case++) {
            sc.nextInt();

            Arrays.fill(countOfScores, 0);
            for (int i = 0; i < 1000; i++)
                countOfScores[sc.nextInt()]++;

            maxOfValue = 0;
            maxOfCount = countOfScores[0];

            for (int i = 1; i < 101; i++) {
                if (maxOfCount <= countOfScores[i]) {
                    maxOfCount = countOfScores[i];
                    maxOfValue = i;
                }
            }

            System.out.println(String.format("#%d %d", test_case, maxOfValue));

        }
    }

}

// https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV13zo1KAAACFAYh&categoryId=AV13zo1KAAACFAYh&categoryType=CODE
