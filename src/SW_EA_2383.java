import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SW_EA_2383 {

    public static void solution(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T, N, place, answer;
        ArrayList<Position_2383> people;
        ArrayList<Position_2383> stair;
        ArrayList<Integer> toStairOne, toStairTwo;
        Integer[][] sTemp;

        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();

            people = new ArrayList<>();
            stair = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    place = sc.nextInt();
                    if (place == 1) {
                        people.add(new Position_2383(j, i,0));
                    }
                    else if (place != 0){
                        stair.add(new Position_2383(j, i, place));
                    }
                }
            }

            toStairOne = new ArrayList<>();
            toStairTwo = new ArrayList<>();
            sTemp = new Integer[2][people.size()];

            int index;
            for (int i = 0; i < people.size(); i++) {
                index = 0;
                if (people.get(i).compareToTime(stair.get(0), stair.get(1)) == 0){
                    toStairOne.add(i);
                }
                else {
                    toStairTwo.add(index, i);
                }
            }

            sTemp[0] = toStairOne.toArray(sTemp[0]);
            sTemp[1] = toStairTwo.toArray(sTemp[1]);

            int onStair, currentTime;
            int[] duration;
            int[] delay;
            int[] size = new int[2];
            size[0] = toStairOne.size();
            size[1] = toStairTwo.size();
            answer = Integer.MAX_VALUE;

            for (int p = 1; p <= people.size(); p++) {
                duration = new int[2];

                sort(sTemp[0], people, 0);
                sort(sTemp[1], people, 1);

                for (int d = 0; d < 2; d++) {
                    onStair = 0;
                    delay = new int[3];
                    for (int i = 0; i < size[d]; i++) {

                        currentTime = people.get(sTemp[d][i]).time[d] + 1;

                        if (delay[onStair%3] <= currentTime) {
                            duration[d] = delay[onStair%3] = currentTime + stair.get(d).length;
                        }
                        else {
                            duration[d] = delay[onStair%3]+= stair.get(d).length;
                        }
                        onStair++;

                    }
                }

                answer = Math.min(answer, (duration[0] > duration[1]) ? duration[0] : duration[1]);

                if (p <= toStairOne.size()) {
                    size[0] = toStairOne.size() - p;
                    sTemp[1][size[1]] = sTemp[0][size[0]];
                    sTemp[0][size[0]] = null;
                    size[1] = toStairTwo.size() + p;
                } else {
                    if (p == toStairOne.size() + 1) {
                        sTemp = new Integer[2][people.size()];
                        sTemp[0] = toStairOne.toArray(sTemp[0]);
                        sTemp[1] = toStairTwo.toArray(sTemp[1]);
                    }
                    int changeP = p - toStairOne.size();
                    size[1] = toStairTwo.size() - changeP;
                    size[0] = toStairOne.size() + changeP;

                    sTemp[0][size[0] - 1] = sTemp[1][size[1]];
                    sTemp[1][size[1]] = null;

                }
            }
        }
    }

    static int min(int a, int b, int aIndex, int bIndex) {
        if (a < b) return aIndex;
        else if (a > b) return bIndex;
        else return (aIndex < bIndex) ? aIndex : bIndex;
    }

    static void sort(Integer[] data, ArrayList<Position_2383> position, int to) {
        Arrays.sort(data, new Comparator<Integer>() {
            @Override
            public int compare(final Integer o1,final Integer o2) {
                if (o1 == null || o1 == null) return 1;
                final int temp1 = position.get(o1).time[to];
                final int temp2 = position.get(o2).time[to];
                return Integer.compare(temp1, temp2);
            }
        });
    }

}

// https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5-BEE6AK0DFAVl
