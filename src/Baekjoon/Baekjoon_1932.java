package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baekjoon_1932 {

    static int N;
    static int trees[][] = new int[501][501];
    static int D[][] = new int[501][501];

    public static void solution() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            st= new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                trees[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                D[i][j] = Math.max(D[i-1][j-1], D[i-1][j]) + trees[i][j];
            }
        }

        int answer = 0;

        for (int i = 1; i <= N; i++) {
            answer = Math.max(D[5][i], answer);
        }

        bw.write(answer + "\n");
        bw.flush();
    }
}

// https://www.acmicpc.net/problem/1932
