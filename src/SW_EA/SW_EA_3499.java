package SW_EA;

import java.util.ArrayList;
import java.util.Scanner;

public class SW_EA_3499 {

    public static void solution() {

        Scanner sc = new Scanner(System.in);
        int numOfCase, num, standard;
        ArrayList<String> arrayOfCard = new ArrayList<>();

        numOfCase = Integer.parseInt(sc.next());
        for (int test_case = 1; test_case <= numOfCase; test_case++) {
            num = Integer.parseInt(sc.next());

            for (int i = 0; i < num; i++) {
                arrayOfCard.add(sc.next());
            }

            if (num%2 != 0) {
                standard = (num / 2) + 1;
            } else standard = num / 2;

            System.out.print(String.format("#%d", test_case));
            for (int i = 0; i < standard; i++) {
                System.out.print(String.format(" %s", arrayOfCard.get(i)));
                if (standard + i < num) System.out.print(String.format(" %s", arrayOfCard.get(standard + i)));
            }
            System.out.println();
            arrayOfCard.clear();
        }
    }

}

// https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWGsRbk6AQIDFAVW&categoryId=AWGsRbk6AQIDFAVW&categoryType=CODE
