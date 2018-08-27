package SW_EA;

import java.util.Scanner;

public class SW_EA_4008 {

    public void solution() throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T, N;
        int[] op = new int[4];
        int[] numbers;
        T=sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N=sc.nextInt();

            for (int i =0; i < 4; i++) op[i] = sc.nextInt();
            numbers = new int[N];
            for (int i =0; i < N; i++) numbers[i] = sc.nextInt();

            answer(op, numbers);
            loop(0, 0, 0);

            System.out.println(String.format("#%d %d", test_case, getAnswer()));
        }
    }

    private int[] operation;
    private int[] literal, seq;
    private int maxScore, minScore;

    void answer(int[] op, int[] n) {
        operation = op;
        literal = n;
        seq = new int[n.length-1];
        maxScore = Integer.MIN_VALUE;
        minScore = Integer.MAX_VALUE;
    }

    void loop(int opType, int at, int step) {
        if (opType > 3) {
            int score = literal[0];
            for (int i = 0; i < seq.length; i++) {
                switch (seq[i]) {
                    case 1:
                        score += literal[i+1];
                        break;
                    case 2:
                        score -= literal[i+1];
                        break;
                    case 3:
                        score *= literal[i+1];
                        break;
                    case 4:
                        score /= literal[i+1];
                        break;
                }
            }
            maxScore = Math.max(maxScore, score);
            minScore = Math.min(minScore, score);
        }
        else if (operation[opType] == 0 || operation[opType] <= step) {
            loop(opType+1, 0, 0);
        }
        else if (opType == 0) {
            for (int i = at; i < seq.length - (operation[opType] - step - 1); i++) {
                seq[i] = opType + 1;
                loop(opType, i+1, step+1);
                seq[i] = 0;
            }
        }
        else {
            for (int i = at; i < seq.length - (operation[opType] - step - 1); i++) {
                if (seq[i] != 0) continue;
                seq[i] = opType + 1;
                loop(opType, 0, step+1);
                seq[i] = 0;
            }
        }

    }

    int getAnswer() {
        return maxScore - minScore;
    }

}

// https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeRZV6kBUDFAVH
