package Baekjoon;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Backjoon_10845 {

    public static void solution(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        String type;
        int x;
        Deque<Integer> queue = new LinkedList<>();
        for (int test_case = 1; test_case <= T; test_case++) {
            type = sc.next();

            if (type.equals("push")) {
                x = sc.nextInt();
                queue.offer(x);
            }
            else if (type.equals("pop")) {
                if (!queue.isEmpty())
                    System.out.println(queue.poll());
                else
                    System.out.println(-1);
            }
            else if (type.equals("size")) {
                System.out.println(queue.size());
            }
            else if (type.equals("empty")) {
                if (!queue.isEmpty())
                    System.out.println(0);
                else
                    System.out.println(1);
            }
            else if (type.equals("front")) {
                if (!queue.isEmpty())
                    System.out.println(queue.peekFirst());
                else
                    System.out.println(-1);
            }
            else if (type.equals("back")) {
                if (!queue.isEmpty())
                    System.out.println(queue.peekLast());
                else
                    System.out.println(-1);
            }
        }
    }

}

// https://www.acmicpc.net/problem/10845
