package SW_EA;

import java.util.Arrays;
import java.util.Scanner;

public class SW_EA_1208 {

    public static void solution(String args[])
    {
        Scanner sc = new Scanner(System.in);

        int num, answer, max, min;

        int lengths[] = new int[101];

        for (int test_case = 1; test_case <= 10; test_case++) {
            num = sc.nextInt();

            Arrays.fill(lengths, 0);
            for (int i = 0; i < 100; i++) {
                lengths[sc.nextInt()]++;
            }

            min = 1;
            while (lengths[min] == 0) min++;
            max = 100;
            while (lengths[max] == 0) max--;

            for (int i = 0; i < num; i++) {
                if (max - 1 > min) {
                    lengths[max]--;
                    lengths[max-1]++;
                    lengths[min]--;
                    lengths[min+1]++;

                    if (lengths[max] <= 0) max -= 1;
                    if (lengths[min] <= 0) min += 1;
                } else break;
            }

            answer = max - min;
            System.out.println(String.format("#%d %d", test_case, answer));
        }
    }

}

// https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV139KOaABgCFAYh&categoryId=AV139KOaABgCFAYh&categoryType=CODE
