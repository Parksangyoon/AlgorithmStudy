package Baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class Baekjoon_10828 {

    public static void solution(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        String type;
        int x;
        Stack<Integer> stack = new Stack();

        for (int test_case = 1; test_case <= T; test_case++) {
            type = sc.next();

            if (type.equals("push")) {
                x = sc.nextInt();
                stack.push(x);
            }
            else if (type.equals("pop")) {
                if (!stack.isEmpty())
                    System.out.println(stack.pop());
                else
                    System.out.println(-1);
            }
            else if (type.equals("size")) {
                System.out.println(stack.size());
            }
            else if (type.equals("empty")) {
                if (!stack.isEmpty())
                    System.out.println(0);
                else
                    System.out.println(1);
            }
            else if (type.equals("top")) {
                if (!stack.isEmpty())
                    System.out.println(stack.peek());
                else
                    System.out.println(-1);
            }
        }
    }

}

// https://www.acmicpc.net/problem/10828
