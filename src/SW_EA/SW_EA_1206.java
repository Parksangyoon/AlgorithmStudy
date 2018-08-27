package SW_EA;

import java.util.ArrayList;
import java.util.Scanner;

public class SW_EA_1206 {

    public static void solutiuon() throws Exception
    {
        Scanner sc = new Scanner(System.in);

        int numOfBuilding, solution, maxOfLength;

        ArrayList<Integer> arrayOfLength = new ArrayList<>();

        for (int test_case = 1; test_case <= 10; test_case++) {
            numOfBuilding = sc.nextInt();

            for (int i=0; i<numOfBuilding; i++) {
                arrayOfLength.add(sc.nextInt());
            }

            solution = 0;

            for (int i=2; i<numOfBuilding-2; i++) {

                if (arrayOfLength.get(i) <= arrayOfLength.get(i-1) || arrayOfLength.get(i) <= arrayOfLength.get(i-2))
                    continue;
                else
                    maxOfLength = arrayOfLength.get(i-1) > arrayOfLength.get(i-2)? arrayOfLength.get(i-1) : arrayOfLength.get(i-2);

                if (arrayOfLength.get(i) > arrayOfLength.get(i+1) && arrayOfLength.get(i) > arrayOfLength.get(i+2)) {
                    if (maxOfLength < arrayOfLength.get(i+1))
                        maxOfLength = arrayOfLength.get(i+1);
                    if (maxOfLength < arrayOfLength.get(i+2))
                        maxOfLength = arrayOfLength.get(i+2);
                    solution += arrayOfLength.get(i) - maxOfLength;
                    i+=2;
                }
            }

            System.out.println(String.format("#%d %d", test_case, solution));
            arrayOfLength.clear();
        }
    }

}

// https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV134DPqAA8CFAYh&categoryId=AV134DPqAA8CFAYh&categoryType=CODE&&&
