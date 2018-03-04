import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SW_EA_3503 {
    public static void solution() throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        int n, max, j;
        ArrayList<Integer> arrayOfLength = new ArrayList<>();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            n = sc.nextInt();
            for (j=0; j<n; j++) {
                arrayOfLength.add(sc.nextInt());
            }
            Collections.sort(arrayOfLength);
            max = arrayOfLength.get(1) - arrayOfLength.get(0);
            for (j=0; j<n-2; j++) {
                if (max < (arrayOfLength.get(j+2) - arrayOfLength.get(j)))
                    max = arrayOfLength.get(j+2) - arrayOfLength.get(j);
            }
            if (max < (arrayOfLength.get(j) - arrayOfLength.get(j+1)))
                max = arrayOfLength.get(j+1) - arrayOfLength.get(j);
            System.out.println(String.format("#%d %d", test_case, max));
            arrayOfLength.clear();
        }
    }
}

// https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWGsV8IaAXsDFAVW&categoryId=AWGsV8IaAXsDFAVW&categoryType=CODE
